package com.intern.demoproject.dto.commom;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ResponseObject<T> {
    String message;
    T data;

    String status;

    boolean result;

    public ResponseObject(T body) {
        this.data = body;
        this.status = HttpStatus.OK.toString();
    }

    public ResponseObject(T body, HttpStatus status) {
        this.data = body;
        this.status = status.toString();
    }

    public ResponseObject(T body, HttpStatus status, boolean result) {
        this.data = body;
        this.status = status.toString();
        this.result = result;
    }
}
