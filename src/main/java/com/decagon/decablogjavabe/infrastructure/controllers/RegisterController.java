package com.decagon.decablogjavabe.infrastructure.controllers;

import com.decagon.decablogjavabe.usercase.payload.request.AdminRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.request.DecadevRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import com.decagon.decablogjavabe.usercase.payload.response.RegistrationResponse;
import com.decagon.decablogjavabe.usercase.services.RegisterService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/register")
@CrossOrigin(origins = "http://localhost:3000/**")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping(value = "/decadev")
    public ResponseEntity<ApiResponse<RegistrationResponse>> registerDecadev(@RequestParam("registration") String registration,@RequestParam("file") MultipartFile file) throws Exception {
        DecadevRegistrationRequest decadevRegistrationRequest = new Gson().fromJson(registration,DecadevRegistrationRequest.class);
        RegistrationResponse response =  registerService.registerDecadev( decadevRegistrationRequest,file);
        return new ResponseEntity<>(new ApiResponse<>("Registered Successfully",true,response), HttpStatus.CREATED);
    }

    @PostMapping(value = "/admin")
    public ResponseEntity<ApiResponse<RegistrationResponse>> registerAdmin(@RequestParam("registration") String registration,@RequestParam("file") MultipartFile file) throws Exception {
        AdminRegistrationRequest adminRegistrationRequest = new Gson().fromJson(registration,AdminRegistrationRequest.class);
      RegistrationResponse response =  registerService.registerAdmin( adminRegistrationRequest,file);
        return new ResponseEntity<>(new ApiResponse<>("Registered Successfully",true,response), HttpStatus.CREATED);
    }
    @GetMapping(value = "/verification")
    public ResponseEntity<ApiResponse<RegistrationResponse>> verifyUser(@Valid @RequestParam("token") String token) throws Exception {
        registerService.verifyUser(token);
        return new ResponseEntity<>(new ApiResponse<>("Registered Successfully",true), HttpStatus.CREATED);
    }
}
