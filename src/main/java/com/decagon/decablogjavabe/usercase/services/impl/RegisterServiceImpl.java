package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.email.ConfirmationTokenEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;
import com.decagon.decablogjavabe.infrastructure.error_handler.CustomNotFoundException;
import com.decagon.decablogjavabe.infrastructure.error_handler.UserAlreadyExistException;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AdminDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AppUserDaoImpl;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.DecadevDaoImpl;
import com.decagon.decablogjavabe.usercase.payload.request.AdminRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.request.DecadevRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.response.RegistrationResponse;
import com.decagon.decablogjavabe.usercase.services.RegisterService;
import com.decagon.decablogjavabe.utils.CloudinaryService;
import com.decagon.decablogjavabe.utils.PayLoadMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final AppUserDaoImpl appUserDao;

    private final DecadevDaoImpl decadevDao;

    private final AdminDaoImpl adminDao;

    private final PasswordEncoder passwordEncoder;

    private final PayLoadMapper payLoadMapper;

    private final CloudinaryService cloudinaryService;

    private final ConfirmationTokenServiceImpl confirmationTokenService;


    @Override
    public RegistrationResponse registerDecadev(@Valid DecadevRegistrationRequest decadevRegistrationRequest, MultipartFile file) throws Exception {
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(decadevRegistrationRequest.getEmail());
        if(appUser != null) {
            throw new UserAlreadyExistException("Email taken");
        }
        Optional<DecadevsEntity> decadevPhoneNumber = decadevDao.findDecadevsEntityByPhoneNumber(decadevRegistrationRequest.getPhoneNumber());
        if(decadevPhoneNumber.isPresent()) {
            throw new UserAlreadyExistException("Phone number already taken");
        }
        String fileUrl = cloudinaryService.uploadImage(file);
        AppUserEntity appUserEntity = AppUserEntity.builder()
                .email(decadevRegistrationRequest.getEmail())
                .password(passwordEncoder.encode(decadevRegistrationRequest.getPassword()))
                .role((Role.DECADEV))
                .build();
        AppUserEntity appUserEntity1 = appUserDao.saveRecord(appUserEntity);

        DecadevsEntity decadev1 = DecadevsEntity.builder()
                .name(decadevRegistrationRequest.getName())
                .phoneNumber(decadevRegistrationRequest.getPhoneNumber())
                .about(decadevRegistrationRequest.getAbout())
                .companyName(decadevRegistrationRequest.getCompanyName())
                .appUserEntity(appUserEntity1)
                .residence(decadevRegistrationRequest.getResidence())
                .displayPicture(fileUrl)
                .build();

        RegistrationResponse response =payLoadMapper.decadevEntityMapper(decadevDao.saveRecord(decadev1));
        String token = UUID.randomUUID().toString();

        ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(
                token,
                LocalDateTime.now().plusMinutes(15),
                appUserEntity1
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return response;
    }

    @Override
    public RegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest, MultipartFile file) throws Exception {
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(adminRegistrationRequest.getEmail());
        if (appUser != null ) {
            throw new UserAlreadyExistException("Email already taken");
        }

        AppUserEntity appUserEntity = AppUserEntity.builder()
                .email(adminRegistrationRequest.getEmail())
                .password(passwordEncoder.encode(adminRegistrationRequest.getPassword()))
                .role(Role.ADMIN)
                .build();
        AppUserEntity appUserEntity1 = appUserDao.saveRecord(appUserEntity);

        String fileUrl = cloudinaryService.uploadImage(file);
        AdminEntity student = AdminEntity
                .builder()
                .name(adminRegistrationRequest.getName())
                .phoneNumber(adminRegistrationRequest.getPhoneNumber())
                .about(adminRegistrationRequest.getAbout())
                .displayPicture(fileUrl)
                .appUserEntity(appUserEntity1)
                .build();
        RegistrationResponse response =payLoadMapper.adminEntityMapper(adminDao.saveRecord(student));
        String token = UUID.randomUUID().toString();

        ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUserEntity1
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return response;
    }

    @Override
    public Object verifyUser(String userToken) {
        ConfirmationTokenEntity confirmationToken = confirmationTokenService.getToken(userToken);
        if (confirmationToken == null) {
            throw new CustomNotFoundException("token not found");
        }
        if (confirmationToken.getConfirmedAt() != null) {
            throw new UserAlreadyExistException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new CustomNotFoundException("token expired");
        }
        confirmationTokenService.setConfirmedAt(userToken);
        return "confirmed";
    }

    }

