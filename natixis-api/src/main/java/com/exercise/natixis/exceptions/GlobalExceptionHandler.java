package com.exercise.natixis.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DuplicateObjectException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateObject(DuplicateObjectException ex) {
        return handle(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

         List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .toList();

        return handle(HttpStatus.BAD_REQUEST, errors.toString());
    }

    public ResponseEntity<Map<String, Object>> handle(HttpStatus httpStatus, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", httpStatus.value());
        body.put("error", httpStatus.getReasonPhrase());
        body.put("message", message);
        return ResponseEntity.status(httpStatus).body(body);
    }

}
