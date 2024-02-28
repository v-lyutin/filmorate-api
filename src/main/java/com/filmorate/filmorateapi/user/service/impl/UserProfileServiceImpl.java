package com.filmorate.filmorateapi.user.service.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.security.exception.IdentityApiServiceException;
import com.filmorate.filmorateapi.user.exception.UserProfileServiceException;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.repository.UserProfileRepository;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final IdentityApiService identityApiService;

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if (userProfileRepository.existsById(userProfile.getId())) {
            throw new UserProfileServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("A user profile with an ID = %d has already been created", userProfile.getId())
            );
        }
        validateNickname(userProfile.getNickname());
        userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getCurrentUserProfile() {
        CurrentUserAccountApiModel currentUserApiModel = identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new IdentityApiServiceException(
                        "For this action the user must be logged in to the system"
                ));
        return getUserProfileById(currentUserApiModel.userAccountId());
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository
                .findById(id)
                .orElseThrow(() -> new UserProfileServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("User with ID = %d not found", id)
                ));
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    @Override
    public void validateNickname(String nickname) {
        if (userProfileRepository.existsByNickname(nickname)) {
            throw new UserProfileServiceException(
                    HttpStatus.BAD_REQUEST,
                    "The nickname is already occupied by another user"
            );
        }
    }
}
