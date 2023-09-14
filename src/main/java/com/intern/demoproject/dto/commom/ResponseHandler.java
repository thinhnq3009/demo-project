package com.intern.demoproject.dto.commom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseHandler {

    public static <T> CustomResponseEntity<T> response(T data, HttpStatus status, boolean result) {
        try {
            return new CustomResponseEntity<>(data, status);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CustomResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
