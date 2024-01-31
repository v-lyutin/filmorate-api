package com.filmorate.filmorateapi.user.usecase.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.usecase.UserProfileRegisterUseCase;
import com.filmorate.filmorateapi.user.web.dto.UserProfileRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {
    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper mapper;

    @Override
    public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
        UserProfile userProfile = mapper.map(registerRequest);
        userProfileService.createUserProfile(userProfile);
    }
}
