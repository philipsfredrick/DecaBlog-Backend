package com.decagon.decablogjavabe.infrastructure.error_handler;

import com.decagon.decablogjavabe.usercase.payload.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(CustomNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse<>((ex.getMessage()),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> EntityAlreadyExistException(UserAlreadyExistException ex) {
        return new ResponseEntity<>(new ApiResponse<>((ex.getMessage()),false), HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(JwtInvalidException.class)
    public ResponseEntity<?> JwtExceptionHandler(JwtInvalidException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<?> AuthenticationFailedExceptionHandler(AuthenticationFailedException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> IOException(IOException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.FORBIDDEN);
    }

}
