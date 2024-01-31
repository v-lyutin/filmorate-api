package com.filmorate.filmorateapi.user.service.impl;

import com.filmorate.filmorateapi.user.exception.UserProfileServiceException;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.repository.UserProfileRepository;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if (userProfileRepository.existsById(userProfile.getId())) {
            throw new UserProfileServiceException("Профиль пользователя с данным ID ранее уже был создан");
        }

        if (userProfileRepository.existsByNickname(userProfile.getNickname())) {
            throw new UserProfileServiceException("Данный никнейм уже занят другим пользователем");
        }

        userProfileRepository.save(userProfile);
    }
}
