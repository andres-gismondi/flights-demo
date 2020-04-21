package com.api.demoproject.application.config.advice;

import com.api.demoproject.application.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> entityNotFound(EntityNotFoundException exception) {
        String errorResponse = exception.getMessage();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericException(Exception exception) {
        String errorResponse = exception.getMessage();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
