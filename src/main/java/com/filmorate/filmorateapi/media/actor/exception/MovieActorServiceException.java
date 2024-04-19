package com.filmorate.filmorateapi.media.actor.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MovieActorServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MovieActorServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
