package com.filmorate.filmorateapi.media.person.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PersonServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public PersonServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
