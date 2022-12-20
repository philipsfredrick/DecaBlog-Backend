package com.decagon.decablogjavabe.infrastructure.error_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppUserNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(AppUserNotFoundException exception, WebRequest webRequest) {
        com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse response = new com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("User Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(SpaceNotFoundException.class)
    public ResponseEntity<Object> spaceExceptions(SpaceNotFoundException exception, WebRequest webRequest) {
        com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse response = new com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Space Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(AppUserAlreadyExistInSpace.class)
    public ResponseEntity<Object> AppUserAlreadyExist(AppUserAlreadyExistInSpace exception, WebRequest webRequest) {
        com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse response = new com.decagon.decablogjavabe.infrastructure.error_handler.ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("This user already exist in this space");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

}
