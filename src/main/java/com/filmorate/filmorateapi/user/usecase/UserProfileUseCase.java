package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.user.web.dto.*;

public interface UserProfileUseCase {
    void registerUserProfile(UserProfileCreationRequest request);

    UserProfilePageResponse getUserProfile();

    void updateNickname(UserProfileUpdateNicknameRequest request);

    void updateImageLink(UserProfileUpdateImageLinkRequest request);
}
