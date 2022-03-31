package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class StudentException extends RuntimeException{

    private String message;

    private HttpStatus httpStatus;

    public StudentException(String message) {
        super();
        this.message = message;
    }

    public StudentException(HttpStatus httpStatus, String message) {
        super();
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
