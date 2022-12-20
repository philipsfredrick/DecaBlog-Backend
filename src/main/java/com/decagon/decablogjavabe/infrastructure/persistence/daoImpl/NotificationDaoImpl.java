package com.decagon.decablogjavabe.infrastructure.persistence.daoImpl;

import com.decagon.decablogjavabe.domain.dao.NotificationDao;
import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import com.decagon.decablogjavabe.infrastructure.persistence.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationDaoImpl extends CrudDaoImpl<NotificationEntity, Long> implements NotificationDao{

    private final NotificationRepository notificationRepository;

    public NotificationDaoImpl(NotificationRepository notificationRepository) {
        super(notificationRepository);
        this.notificationRepository = notificationRepository;
    }


    @Override
    public List<NotificationEntity> getAllNotificatioinsByAdminIdOrDecadevId(Long id) {
        return notificationRepository.getAllNotificatioinsByAdminIdOrDecadevId(id);
    }
}
