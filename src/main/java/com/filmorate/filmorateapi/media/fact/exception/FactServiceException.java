package com.filmorate.filmorateapi.media.fact.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FactServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public FactServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
