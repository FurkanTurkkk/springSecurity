package com.springsecurity.jwt_token.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IllegalArgumentException {

    @ExceptionHandler(java.lang.IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(java.lang.IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
