package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.AppUserDao;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.AppUserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
@Getter
@Setter
@Service
public class AppUserDaoImpl extends CrudDaoImpl<AppUserEntity, Long> implements AppUserDao {

    private final AppUserRepository appUserRepository;

    public AppUserDaoImpl(AppUserRepository appUserRepository) {
        super(appUserRepository);
        this.appUserRepository = appUserRepository;
    }


    @Override
    public AppUserEntity findAppUserEntityByEmail(String email) {
        return appUserRepository.findAppUserEntityByEmail(email);
    }

    @Override
    public AppUserEntity findAppUserEntityByEmailAndRole(String email, Role role) {
        return appUserRepository.findAppUserEntityByEmailAndRole(email, role);
    }
}
