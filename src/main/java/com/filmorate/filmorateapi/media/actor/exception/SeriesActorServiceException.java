package com.filmorate.filmorateapi.media.actor.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SeriesActorServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SeriesActorServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
