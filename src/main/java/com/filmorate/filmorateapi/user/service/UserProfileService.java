package com.filmorate.filmorateapi.user.service;

import com.filmorate.filmorateapi.user.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    UserProfile getUserProfile();

    UserProfile getUserProfileById(Long id);

    void updateUserProfile(UserProfile userProfile);

    void validateNickname(String nickname);
}
