package com.decagon.decablogjavabe.infrastructure.persistence.repository;


import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DecadevsRepository extends JpaRepository<DecadevsEntity, Long> {

    DecadevsEntity getByAppUserEntity(AppUserEntity appUserEntity);

    Optional<DecadevsEntity> findDecadevsEntityByPhoneNumber(String phoneNumber);

}
