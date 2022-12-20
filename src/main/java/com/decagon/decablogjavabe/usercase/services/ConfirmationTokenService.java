package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.domain.entities.email.ConfirmationTokenEntity;

public interface ConfirmationTokenService {
     void saveConfirmationToken(ConfirmationTokenEntity token);
     ConfirmationTokenEntity getToken(String token);
     int setConfirmedAt(String token);
}
