package com.intern.demoproject.dto.commom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseHandler {

    public static ResponseEntity<Object> response(Object data, HttpStatus status, boolean result) {
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("timestamp", new Date());
            map.put("data", data);
            map.put("status", status.value());
            map.put("result", result);
            return new ResponseEntity<>(map, status);
        } catch (Exception e) {
            log.error(e.getMessage());
            map.clear();
            map.put("timestamp", new Date());
            map.put("data",null);
            map.put("message", e.getMessage());
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            map.put("result", false);
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
