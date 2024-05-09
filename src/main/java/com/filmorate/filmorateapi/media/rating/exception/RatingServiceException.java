package com.filmorate.filmorateapi.media.rating.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RatingServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public RatingServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
