package com.intern.demoproject.dto.commom;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseObject<T> {
    String message;

    T data;

    String status;

    boolean result;

    Date timestamp = new Date();

    public ResponseObject(T body, HttpStatus status) {
        this.data = body;
        this.status = status.toString();
        this.result = status.is2xxSuccessful();
        this.timestamp = new Date();
    }
}
