package com.filmorate.filmorateapi.media.staff.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StaffRoleServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public StaffRoleServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
