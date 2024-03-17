package com.filmorate.filmorateapi.media.genre.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenreServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public GenreServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
