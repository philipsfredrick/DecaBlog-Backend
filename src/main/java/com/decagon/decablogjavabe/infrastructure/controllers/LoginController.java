package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.usercase.payload.request.LoginRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.LoginResponse;
import com.decagon.decablogjavabe.usercase.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/decadev")
    public ResponseEntity<ApiResponse<LoginResponse>> loginDecadev(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse response  = loginService.loginDecadev(loginRequest);
        return new ResponseEntity<>(new ApiResponse<>("Login Successful",true,response), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/admin")
    public ResponseEntity<ApiResponse<LoginResponse>> loginAdmin(@Valid @RequestBody LoginRequest loginRequest)  {
        LoginResponse response = loginService.loginAdmin(loginRequest);
        return new ResponseEntity<>(new ApiResponse<>("Login Successful",true,response), HttpStatus.ACCEPTED);
    }


}
