package com.filmorate.filmorateapi.user.usecase.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileToUserProfileResponseMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileUpdateMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.usecase.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileUseCaseFacade implements UserProfileUseCase {
    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper userProfileRegisterRequestToUserProfileMapper;
    private final UserProfileToUserProfileResponseMapper userProfileToUserProfileResponseMapper;
    private final UserProfileUpdateMapper userProfileUpdateMapper;

    @Override
    public void registerUserProfile(UserProfileCreationRequest request) {
        UserProfile userProfile = userProfileRegisterRequestToUserProfileMapper.map(request);
        userProfileService.createUserProfile(userProfile);
    }

    @Override
    public UserProfileResponse getUserProfile() {
        UserProfile userProfile = userProfileService.getUserProfile();
        return userProfileToUserProfileResponseMapper.map(userProfile);
    }

    @Override
    public UserProfileResponse updateUserProfile(UserProfileUpdateRequest request) {
        UserProfile userProfile = userProfileService.getUserProfile();
        userProfileUpdateMapper.map(request, userProfile);
        userProfileService.updateUserProfile(userProfile);
        return userProfileToUserProfileResponseMapper.map(userProfile);
    }
}
