package com.filmorate.filmorateapi.media.compilation.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CompilationServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CompilationServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
