package com.filmorate.filmorateapi.security.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserRoleServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public UserRoleServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
