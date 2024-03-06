package com.filmorate.filmorateapi.media.movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MovieServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
