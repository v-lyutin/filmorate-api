package com.filmorate.filmorateapi.security.exception;

public class JwtAccessTokenServiceException extends RuntimeException {
    public JwtAccessTokenServiceException(String message) {
        super(message);
    }
}
