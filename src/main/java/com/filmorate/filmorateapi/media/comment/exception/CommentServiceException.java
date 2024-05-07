package com.filmorate.filmorateapi.media.comment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommentServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public CommentServiceException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
