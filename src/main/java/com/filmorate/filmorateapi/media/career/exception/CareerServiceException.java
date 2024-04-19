package com.filmorate.filmorateapi.media.career.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CareerServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CareerServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
