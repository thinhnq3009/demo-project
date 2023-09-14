package com.intern.demoproject.exception.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class ArchitectureException extends Exception{
    protected String code;
    protected String message;
    protected String stack;
    protected HttpStatus status;

}
