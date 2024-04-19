package com.filmorate.filmorateapi.media.staff.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StaffServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public StaffServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

