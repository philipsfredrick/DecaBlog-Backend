package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.DecadevsEntity;
import com.decagon.decablogjavabe.domain.entities.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpaceDao extends JpaRepository<SpaceEntity, Long> {


    @Query("SELECT s from space s inner join s.decadevsEntity u where u.id=?1")
    public SpaceEntity getSpaceByDecadevId(Long id);

    @Query("SELECT s from space s inner join s.adminEntity u where u.id=?1")
    public SpaceEntity getSpaceByAdminId(Long id);


}
