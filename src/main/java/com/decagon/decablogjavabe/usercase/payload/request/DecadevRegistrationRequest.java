package com.decagon.decablogjavabe.usercase.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DecadevRegistrationRequest {

    private String name;

    private String email;

    private String password;

    private String phoneNumber;

    private String about;

    private String companyName;

    private String residence;
}
