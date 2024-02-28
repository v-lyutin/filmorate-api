package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import org.springframework.http.ResponseEntity;

public interface UserProfileUseCase {
    void registerUserProfile(UserProfileCreationRequest request);

    CurrentUserProfileResponse getUserProfile();

    CurrentUserProfileResponse updateUserProfile(UserProfileUpdateRequest request);

    ResponseEntity<Object> getUserProfileById(Long userProfileId);
}
