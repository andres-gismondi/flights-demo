package com.api.demoproject.application.config.advice;

import com.api.demoproject.application.exceptions.EntityNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getBindingResult().getAllErrors();
        Iterator<ObjectError> it = errors.iterator();
        ArrayList<String> array = new ArrayList<>();
        while (it.hasNext()) {
            ObjectError error = it.next();
            Object[] arguments = error.getArguments();
            DefaultMessageSourceResolvable some = (DefaultMessageSourceResolvable) arguments[0];
            array.add(some.getCode() + ":" + error.getDefaultMessage());
        }
        String errorResponse = array.toString();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
