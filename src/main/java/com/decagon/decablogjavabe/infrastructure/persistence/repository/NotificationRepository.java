package com.decagon.decablogjavabe.infrastructure.persistence.repository;

import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    @Query(value="SELECT * FROM  notification n WHERE n.admin_id = ?1 OR n.decadevs_entity_id= ?1", nativeQuery = true)
    List<NotificationEntity> getAllNotificatioinsByAdminIdOrDecadevId(Long id);
}
