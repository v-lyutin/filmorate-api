package com.filmorate.filmorateapi.security.usecase;

import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
