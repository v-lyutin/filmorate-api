package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.UserProfilePageResponse;
import com.filmorate.filmorateapi.user.web.dto.UserProfileRegisterRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateImageLinkRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateNicknameRequest;

public interface UserProfileUtilUseCase {
    void registerUserProfile(UserProfileRegisterRequest request);

    UserProfilePageResponse getUserProfile();

    void updateNickname(UserProfileUpdateNicknameRequest request);

    void updateImageLink(UserProfileUpdateImageLinkRequest request);
}
