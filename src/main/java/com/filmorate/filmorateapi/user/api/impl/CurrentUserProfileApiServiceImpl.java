package com.filmorate.filmorateapi.user.api.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.api.exception.CurrentUserProfileApiServiceException;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {
    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserAccountApiModel currentUserAccountApiModel = identityApiService.currentUserAccount()
                .orElseThrow(() -> new CurrentUserProfileApiServiceException("Not authorized", HttpStatus.UNAUTHORIZED));
        return userProfileService.getUserProfileById(currentUserAccountApiModel.userAccountId());
    }
}
