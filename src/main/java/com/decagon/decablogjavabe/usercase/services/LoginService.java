package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.usercase.payload.request.LoginRequest;
import com.decagon.decablogjavabe.usercase.payload.response.LoginResponse;

public interface LoginService {

    LoginResponse loginDecadev(LoginRequest loginRequest);

    LoginResponse loginAdmin(LoginRequest loginRequest);
}
