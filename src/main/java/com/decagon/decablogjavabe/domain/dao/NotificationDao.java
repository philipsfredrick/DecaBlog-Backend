package com.decagon.decablogjavabe.domain.dao;

import com.decagon.decablogjavabe.domain.entities.LikeEntity;
import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationDao extends CrudDao<NotificationEntity, Long>{

    List<NotificationEntity> getAllNotificatioinsByAdminIdOrDecadevId(Long id);
}
