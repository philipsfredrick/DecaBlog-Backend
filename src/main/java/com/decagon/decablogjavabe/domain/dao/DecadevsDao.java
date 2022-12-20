package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;

import java.util.Optional;

public interface DecadevsDao extends CrudDao<DecadevsEntity, Long>{
    DecadevsEntity getByAppUser(AppUserEntity appUserEntity);

    Optional<DecadevsEntity> findDecadevsEntityByPhoneNumber(String phoneNumber);

}
