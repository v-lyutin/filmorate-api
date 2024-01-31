package com.filmorate.filmorateapi.user.usecase.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileToUserProfilePageResponseMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.usecase.UserProfileUtilUseCase;
import com.filmorate.filmorateapi.user.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserProfileUtilUseCaseFacade implements UserProfileUtilUseCase {
    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper userProfileRegisterRequestToUserProfileMapper;
    private final UserProfileToUserProfilePageResponseMapper userProfileToUserProfilePageResponseMapper;

    @Override
    public void registerUserProfile(UserProfileRegisterRequest request) {
        UserProfile userProfile = userProfileRegisterRequestToUserProfileMapper.map(request);
        userProfileService.createUserProfile(userProfile);
    }

    @Override
    public UserProfilePageResponse getUserProfile() {
        UserProfile userProfile = userProfileService.getUserProfile();
        return userProfileToUserProfilePageResponseMapper.map(userProfile);
    }

    @Override
    public void updateNickname(UserProfileUpdateNicknameRequest request) {
        UserProfile userProfile = userProfileService.getUserProfile();
        if (Objects.equals(userProfile.getNickname(), request.nickname())) {
            return;
        }
        userProfileService.validateNickname(request.nickname());
        userProfile.setNickname(request.nickname());
        userProfileService.updateUserProfile(userProfile);
    }

    @Override
    public void updateImageLink(UserProfileUpdateImageLinkRequest request) {
        UserProfile userProfile = userProfileService.getUserProfile();
        if (Objects.equals(userProfile.getImageLink(), request.imageLink())) {
            return;
        }
        userProfile.setImageLink(request.imageLink());
        userProfileService.updateUserProfile(userProfile);
    }

    @Override
    public void updatePassword(UserProfileUpdatePasswordRequest request) {

    }
}
