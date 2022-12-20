package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import com.decagon.decablogjavabe.usercase.payload.response.NotificationResponse;

import java.util.List;

public interface NotificationService {

    List<NotificationEntity> getAllNotifications();

    List<NotificationResponse> allNotificationsOfA_DecadevById();

    List<NotificationResponse> allNotificationsOfA_AdminById();
}
