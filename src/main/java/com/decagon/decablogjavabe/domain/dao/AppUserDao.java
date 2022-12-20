package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;

public interface AppUserDao extends CrudDao<AppUserEntity, Long>{

    AppUserEntity findAppUserEntityByEmail(String email);

    AppUserEntity findAppUserEntityByEmailAndRole(String email, Role role);

}
