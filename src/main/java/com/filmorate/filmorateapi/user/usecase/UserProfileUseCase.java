package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.*;

public interface UserProfileUseCase {
    void registerUserProfile(UserProfileCreationRequest request);

    UserProfileResponse getUserProfile();

    UserProfileResponse updateUserProfile(UserProfileUpdateRequest request);
}
