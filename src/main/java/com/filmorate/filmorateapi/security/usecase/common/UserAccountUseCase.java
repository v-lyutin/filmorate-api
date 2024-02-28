package com.filmorate.filmorateapi.security.usecase.common;

import com.filmorate.filmorateapi.security.web.dto.response.AccessToken;
import com.filmorate.filmorateapi.security.web.dto.request.LoginRequest;
import com.filmorate.filmorateapi.security.web.dto.request.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.request.RegisterRequest;

public interface UserAccountUseCase {
    void register(RegisterRequest registerRequest);

    AccessToken authenticate(LoginRequest loginRequest);

    void updatePassword(PasswordRequest passwordRequest);
}
