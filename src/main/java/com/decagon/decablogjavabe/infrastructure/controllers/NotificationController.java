package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.domain.entities.NotificationEntity;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.NotificationResponse;
import com.decagon.decablogjavabe.usercase.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/v1")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notifications")
    public ResponseEntity<ApiResponse<List<NotificationEntity>>>  getAllNotificationsByAdminOrDecadev(){
        return new ResponseEntity<>(new ApiResponse<>("Success",true,notificationService.getAllNotifications()), HttpStatus.OK);
    }

}