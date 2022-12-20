package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;
import com.decagon.decablogjavabe.infrastructure.configuration.security.JwtTokenProvider;
import com.decagon.decablogjavabe.infrastructure.configuration.security.UserPrincipalService;
import com.decagon.decablogjavabe.infrastructure.error_handler.CustomNotFoundException;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AppUserDaoImpl;
import com.decagon.decablogjavabe.usercase.payload.request.LoginRequest;
import com.decagon.decablogjavabe.usercase.payload.response.LoginResponse;
import com.decagon.decablogjavabe.usercase.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional
public class LoginServiceImpl implements LoginService {

    private AppUserDaoImpl appUserDao;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserPrincipalService userPrincipalService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse loginDecadev(LoginRequest decadevLoginRequest) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(decadevLoginRequest
                        .getEmail(), decadevLoginRequest.getPassword()));
        if (!auth.isAuthenticated() ) {
            throw new com.decagon.decablogjavabe.infrastructure.error_handler.AuthenticationFailedException("Wrong email or password");
        }
        AppUserEntity appUserEntity = appUserDao
                .findAppUserEntityByEmailAndRole(decadevLoginRequest.getEmail(), Role.DECADEV);
        if(appUserEntity == null){
            throw new CustomNotFoundException("Invalid Email or password");
        }
        if(!appUserEntity.getRole().equals(Role.DECADEV)){
            throw new com.decagon.decablogjavabe.infrastructure.error_handler.AuthenticationFailedException("Unauthorised");
        }
        String token = jwtTokenProvider
                .generateToken(new org.springframework.security.core.userdetails
                        .User(decadevLoginRequest.getEmail(), decadevLoginRequest.getPassword(), new ArrayList<>()));
        return new LoginResponse(token, appUserEntity.getId());
    }

    @Override
    public LoginResponse loginAdmin(LoginRequest adminLoginRequest) {
        UserDetails userDetailsService = userPrincipalService.loadUserByUsername(adminLoginRequest.getEmail());
        if(userDetailsService == null){
            throw new CustomNotFoundException("Wrong email");
        }

        if(!(passwordEncoder.matches(adminLoginRequest.getPassword(),userDetailsService.getPassword()))){
            throw new CustomNotFoundException("Wrong password");
        }

        AppUserEntity appUserEntity = appUserDao
                .findAppUserEntityByEmailAndRole(adminLoginRequest.getEmail(),Role.ADMIN);
        if(appUserEntity == null){
            throw new CustomNotFoundException("User does not exist");
        }

        String token = jwtTokenProvider
                .generateToken(new org.springframework.security.core.userdetails
                        .User(adminLoginRequest.getEmail(), adminLoginRequest.getPassword(), new ArrayList<>()));
        return new LoginResponse(token, appUserEntity.getId());
    }
}
