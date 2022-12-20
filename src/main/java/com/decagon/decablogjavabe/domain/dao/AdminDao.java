package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.AdminEntity;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;

public interface AdminDao extends CrudDao<AdminEntity, Long>{

    AdminEntity getByAppUser(AppUserEntity appUserEntity);

}
