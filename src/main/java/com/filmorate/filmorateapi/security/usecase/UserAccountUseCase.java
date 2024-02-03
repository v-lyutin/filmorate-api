package com.filmorate.filmorateapi.security.usecase;

import com.filmorate.filmorateapi.security.web.dto.AccessToken;
import com.filmorate.filmorateapi.security.web.dto.LoginRequest;
import com.filmorate.filmorateapi.security.web.dto.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;

public interface UserAccountUseCase {
    void register(RegisterRequest registerRequest);

    AccessToken authenticate(LoginRequest loginRequest);

    void updatePassword(PasswordRequest passwordRequest);
}
