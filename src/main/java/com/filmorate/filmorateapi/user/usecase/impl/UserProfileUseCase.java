package com.filmorate.filmorateapi.user.usecase.impl;

import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import org.springframework.http.ResponseEntity;

public interface UserProfileUseCase {
    CurrentUserProfileResponse registerUserProfile(UserProfileCreationRequest request);

    CurrentUserProfileResponse getCurrentUserProfile();

    CurrentUserProfileResponse updateUserProfile(UserProfileUpdateRequest request);

    ResponseEntity<Object> getUserProfileById(Long userProfileId);
}
