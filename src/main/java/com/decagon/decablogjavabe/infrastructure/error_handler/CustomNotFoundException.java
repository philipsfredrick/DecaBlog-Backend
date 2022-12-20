package com.decagon.decablogjavabe.infrastructure.error_handler;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
