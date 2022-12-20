package com.decagon.decablogjavabe.usercase.services.impl;

import com.decagon.decablogjavabe.domain.dao.AppUserDao;
import com.decagon.decablogjavabe.domain.dao.NotificationDao;
import com.decagon.decablogjavabe.domain.entities.AppUserEntity;
import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import com.decagon.decablogjavabe.infrastructure.configuration.security.UserDetails;
import com.decagon.decablogjavabe.usercase.payload.response.NotificationResponse;
import com.decagon.decablogjavabe.usercase.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDao notificationDao;

    private final AppUserDao appUserDao;


    @Override
    public List<NotificationEntity> getAllNotifications(){
        String userEmail = UserDetails.getLoggedInUserDetails();
        AppUserEntity appUser = appUserDao.findAppUserEntityByEmail(userEmail);
        List <NotificationEntity> notifications = notificationDao.getAllNotificatioinsByAdminIdOrDecadevId(appUser.getId());
        return notifications;
    }

    @Override
    public List<NotificationResponse> allNotificationsOfA_DecadevById() {


        return null;
    }

    @Override
    public List<NotificationResponse> allNotificationsOfA_AdminById() {
        return null;
    }

}
