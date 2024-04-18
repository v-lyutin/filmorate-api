package com.filmorate.filmorateapi.media.series.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EpisodeServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public EpisodeServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
