package com.decagon.decablogjavabe.usercase.services;

import com.decagon.decablogjavabe.usercase.payload.request.AdminRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.request.DecadevRegistrationRequest;
import com.decagon.decablogjavabe.usercase.payload.response.RegistrationResponse;
import org.springframework.web.multipart.MultipartFile;

public interface RegisterService {

    RegistrationResponse registerDecadev(DecadevRegistrationRequest decadevRegistrationRequest, MultipartFile file) throws Exception;

    RegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest, MultipartFile file) throws Exception;

    Object verifyUser(String userToken);
}
