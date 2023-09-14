package com.intern.demoproject.exception.commom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<?> getErrorResponse(Exception e, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();

        map.put("message", e.getMessage());
        map.put("status", status.getReasonPhrase());
        map.put("code", status.value());
        map.put("data", null);

        return ResponseEntity.status(status).body(map);
    }

    public ResponseEntity<?> getErrorResponse(Exception e) {
        return getErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleException(Exception e) {
        return getErrorResponse(e, HttpStatus.NOT_FOUND);
    }


}
