package com.filmorate.filmorateapi.media.series.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SeasonServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SeasonServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
