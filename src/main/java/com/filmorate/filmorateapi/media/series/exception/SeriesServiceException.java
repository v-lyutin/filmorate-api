package com.filmorate.filmorateapi.media.series.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SeriesServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SeriesServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
