package com.intern.demoproject.dto.commom;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CustomResponseEntity<T> extends ResponseEntity<ResponseObject<T>> {
    public CustomResponseEntity(HttpStatus status) {
        super(status);
    }

    public CustomResponseEntity(T body, HttpStatus status) {
        super(new ResponseObject<>(body, status), status);
    }

    public CustomResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public CustomResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(new ResponseObject<>(body, status), headers, status);
    }


}
