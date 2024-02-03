package com.filmorate.filmorateapi.security.service;

import org.springframework.security.core.Authentication;

public interface AccessTokenService {
    String generateToken(Authentication authentication);
}
