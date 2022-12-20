package com.decagon.decablogjavabe.infrastructure.configuration.security;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.daoImpl.AppUserDaoImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserPrincipalService implements UserDetailsService {

    private final AppUserDaoImpl appUserDao;

    public UserPrincipalService(AppUserDaoImpl appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUserEntity user = appUserDao.findAppUserEntityByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("wrong email");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
