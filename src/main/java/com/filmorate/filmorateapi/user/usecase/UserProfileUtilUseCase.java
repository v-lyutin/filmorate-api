package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.*;

public interface UserProfileUtilUseCase {
    void registerUserProfile(UserProfileRegisterRequest request);

    UserProfilePageResponse getUserProfile();

    void updateNickname(UserProfileUpdateNicknameRequest request);

    void updateImageLink(UserProfileUpdateImageLinkRequest request);

    void updatePassword(UserProfileUpdatePasswordRequest request);
}
