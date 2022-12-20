package com.decagon.decablogjavabe.infrastructure.error_handler;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
