package com.filmorate.filmorateapi.user.usecase.common;

import com.filmorate.filmorateapi.user.mapper.UserProfileRegisterRequestToUserProfileMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileToCurrentUserProfileResponseMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileToUserProfileResponseMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileUpdateMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.usecase.common.impl.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserProfileUseCaseFacade implements UserProfileUseCase {
    private final UserProfileService userProfileService;
    private final UserProfileRegisterRequestToUserProfileMapper userProfileRegisterRequestToUserProfileMapper;
    private final UserProfileToCurrentUserProfileResponseMapper userProfileToCurrentUserProfileResponseMapper;
    private final UserProfileUpdateMapper userProfileUpdateMapper;
    private final UserProfileToUserProfileResponseMapper userProfileToUserProfileResponseMapper;

    @Override
    public CurrentUserProfileResponse registerUserProfile(UserProfileCreationRequest request) {
        UserProfile userProfile = userProfileRegisterRequestToUserProfileMapper.map(request);
        userProfileService.createUserProfile(userProfile);
        return userProfileToCurrentUserProfileResponseMapper.map(userProfile);
    }

    @Override
    public CurrentUserProfileResponse getCurrentUserProfile() {
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        return userProfileToCurrentUserProfileResponseMapper.map(userProfile);
    }

    @Override
    public CurrentUserProfileResponse updateUserProfile(UserProfileUpdateRequest request) {
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        userProfileUpdateMapper.map(request, userProfile);
        userProfileService.updateUserProfile(userProfile);
        return userProfileToCurrentUserProfileResponseMapper.map(userProfile);
    }

    @Override
    @SneakyThrows
    public ResponseEntity<Object> getUserProfileById(Long userProfileId) {
        UserProfile requiredUserProfile = userProfileService.getUserProfileById(userProfileId);
        UserProfile currentUserProfile = userProfileService.getCurrentUserProfile();
        if (Objects.equals(userProfileId, currentUserProfile.getId())) {
            URI uri = new URI("http://localhost:8080/api/v1/profiles/me");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        }
        return new ResponseEntity<>(userProfileToUserProfileResponseMapper.map(requiredUserProfile), HttpStatus.OK);
    }
}
