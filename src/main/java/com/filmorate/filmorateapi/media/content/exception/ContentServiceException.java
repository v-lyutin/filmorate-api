package com.filmorate.filmorateapi.media.content.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ContentServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ContentServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
