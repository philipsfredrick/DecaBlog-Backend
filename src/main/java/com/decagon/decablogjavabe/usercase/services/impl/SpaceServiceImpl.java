package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.AdminDao;
import com.decagon.decablogjavabe.domain.dao.AppUserDao;
import com.decagon.decablogjavabe.domain.dao.DecadevsDao;
import com.decagon.decablogjavabe.domain.dao.SpaceDao;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.SpaceEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;
import com.decagon.decablogjavabe.infrastructure.error_handler.AppUserAlreadyExistInSpace;
import com.decagon.decablogjavabe.infrastructure.error_handler.AppUserNotFoundException;
import com.decagon.decablogjavabe.infrastructure.error_handler.SpaceNotFoundException;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.SpaceRepository;
import com.decagon.decablogjavabe.usercase.payload.request.SpaceRequest;
import com.decagon.decablogjavabe.usercase.payload.response.SpaceResponse;
import com.decagon.decablogjavabe.usercase.services.SpaceService;
import com.decagon.decablogjavabe.utils.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SpaceServiceImpl implements SpaceService {
    private final SpaceDao spaceDao;
    private final AppUserDao appUserDao;
    private  final DecadevsDao decadevsDao;
    private final AdminDao adminDao;

    private final SpaceRepository spaceRepository;

    private final CloudinaryService cloudinaryService;
    @Override
    public SpaceResponse<?> createSpace(SpaceRequest spaceRequest, MultipartFile image) throws IOException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = ((UserDetails) principal).getUsername();
        AppUserEntity user = appUserDao.findAppUserEntityByEmail(userEmail);
        String imageUrl = cloudinaryService.uploadImage(image);
        SpaceEntity spaceEntity = SpaceEntity.builder()
                .title(spaceRequest.getTitle())
                .description(spaceRequest.getDescription())
                .image(imageUrl)
                .build();
        if (user.getRole().equals(Role.DECADEV)){
            spaceEntity.setDecadevsEntity(decadevsDao.getByAppUser(user));
        }else {
            spaceEntity.setAdminEntity(adminDao.getByAppUser(user));
        }
            return new SpaceResponse<>("success", true, LocalDateTime.now(), spaceDao.save(spaceEntity));
        }


    @Override
    public SpaceEntity inviteToSpace(Long id, Long userId) {
        SpaceEntity spaceEntity = spaceDao.findById(id).orElseThrow(SpaceNotFoundException::new);
        DecadevsEntity decadevsEntity = decadevsDao.findById(userId).orElseThrow(AppUserNotFoundException::new);
        if(spaceDao.getSpaceByDecadevId (userId) == spaceEntity){
            throw  new AppUserAlreadyExistInSpace();
        }else{
            spaceEntity.setDecadevsEntity(decadevsEntity);
            return spaceDao.save(spaceEntity);

        }
    }
    @Override
    public SpaceEntity joinSpace(Long spaceId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = ((UserDetails) principal).getUsername();
        AppUserEntity user = appUserDao.findAppUserEntityByEmail(userEmail);
        SpaceEntity spaceEntity = spaceDao.findById(spaceId).orElseThrow(SpaceNotFoundException::new);
        if (spaceEntity.getAppUsers().contains(user)){
            throw  new AppUserAlreadyExistInSpace();
        }
        spaceEntity.getAppUsers().add(user);
        return spaceDao.save(spaceEntity);
    }

    public List <SpaceEntity> getAllSpace(){
        List <SpaceEntity> allSpaceEntityList =spaceDao.findAll();

        return allSpaceEntityList;
    }
}
