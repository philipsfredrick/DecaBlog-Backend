package com.decagon.decablogjavabe.usercase.payload.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private Long userId;

    public LoginResponse(String accessToken, Long userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

}
