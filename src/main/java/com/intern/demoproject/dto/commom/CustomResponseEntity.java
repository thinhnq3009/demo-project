package com.intern.demoproject.dto.commom;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

public class CustomResponseEntity<T> extends ResponseEntity<ResponseObject<T>> {
    public CustomResponseEntity(HttpStatus status) {
        this(null, null, status);
    }

    public CustomResponseEntity(T body, HttpStatus status) {
        this(body, null, status);
    }

    public CustomResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        this(null, headers, status);
    }

    public CustomResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(new ResponseObject<>(body, status), headers, status);
    }

    public static <T> CustomResponseEntity<T> of(T body, HttpStatus status) {
        return new CustomResponseEntity<>(body, status);
    }

    public static <T> CustomResponseEntity<T> of(T body) {
        return new CustomResponseEntity<>(body, HttpStatus.OK);
    }

    public static <T> CustomResponseEntity<T> of(HttpStatus status) {
        return new CustomResponseEntity<>(status);
    }

    public static <T> CustomResponseEntity<T> of(HttpStatus status, MultiValueMap<String, String> headers) {
        return new CustomResponseEntity<>(headers, status);
    }


    public void setMessage(String message) {
        ResponseObject<T> body = this.getBody();
        Assert.notNull(body, "Response body must not be null");
        body.setMessage(message);
    }



    public CustomResponseEntity<T> message(String message) {
        setMessage(message);
        return this;
    }

    public CustomResponseEntity<T> result(boolean result) {
        ResponseObject<T> body = this.getBody();
        Assert.notNull(body, "Response body must not be null");
        body.setResult(result);
        return this;
    }
}
