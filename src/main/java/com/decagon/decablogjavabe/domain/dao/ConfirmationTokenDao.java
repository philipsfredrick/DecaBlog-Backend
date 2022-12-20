package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.email.ConfirmationTokenEntity;

import java.time.LocalDateTime;

public interface ConfirmationTokenDao extends CrudDao<ConfirmationTokenEntity, Long>{
    int updateConfirmedAt(String token, LocalDateTime now);
    ConfirmationTokenEntity findByToken (String token);
}
