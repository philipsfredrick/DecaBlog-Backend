package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {

    AppUserEntity findAppUserEntityByEmail(String email);

    AppUserEntity findAppUserEntityByEmailAndRole(String email, Role role);

}
