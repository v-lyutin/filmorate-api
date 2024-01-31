package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest registerRequest);
}
