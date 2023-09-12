package com.intern.demoproject.dto.commom;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class ResponseObject<T> {
    String message;

    T data;

    String status;

    boolean result;

    public ResponseObject(T body, HttpStatus status) {
        this.data = body;
        this.status = status.toString();
        this.result = status.is2xxSuccessful();
    }
}
