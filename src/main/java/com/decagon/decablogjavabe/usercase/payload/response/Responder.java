package com.decagon.decablogjavabe.usercase.payload.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class Responder {

    public static ResponseEntity<ApiResponse> okayQuestions(Object response){
        return  new  ResponseEntity<>(new ApiResponse("Question Created Successfuly", true, response), HttpStatus.OK);
    }
}
