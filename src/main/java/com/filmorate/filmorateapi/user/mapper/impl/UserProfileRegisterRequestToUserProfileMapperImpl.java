package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.security.exception.IdentityApiServiceException;
import com.filmorate.filmorateapi.user.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRegisterRequestToUserProfileMapperImpl
        implements UserProfileRegisterRequestToUserProfileMapper {
    private final IdentityApiService identityApiService;

    @Override
    public UserProfile map(UserProfileCreationRequest registerRequest) {
        CurrentUserAccountApiModel currentUserApiModel = identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new IdentityApiServiceException(
                        "For this action the user must be logged in to the system")
                );
        UserProfile userProfile = new UserProfile();
        userProfile.setId(currentUserApiModel.userAccountId());
        userProfile.setNickname(registerRequest.nickname());
        userProfile.setImageLink(registerRequest.imageLink());
        return userProfile;
    }
}
