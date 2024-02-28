package com.filmorate.filmorateapi.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserProfileServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public UserProfileServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
