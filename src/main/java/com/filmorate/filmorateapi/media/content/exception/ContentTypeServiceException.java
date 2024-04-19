package com.filmorate.filmorateapi.media.content.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ContentTypeServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ContentTypeServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
