package com.filmorate.filmorateapi.user.service.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.security.exception.IdentityApiServiceException;
import com.filmorate.filmorateapi.user.exception.UserProfileServiceException;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.repository.UserProfileRepository;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final IdentityApiService identityApiService;

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

    @Override
    public UserProfile getUserProfile() {
        CurrentUserAccountApiModel currentUserApiModel = identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new IdentityApiServiceException(
                        "Для данного действия пользователь должен быть авторизован в системе"
                ));

        return getUserProfileById(currentUserApiModel.userAccountId());
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository
                .findById(id)
                .orElseThrow(() -> new UserProfileServiceException("Информация о пользователе не найдена"));
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        if (!userProfileRepository.existsById(userProfile.getId())) {
            throw new UserProfileServiceException("Пользователя с данным ID не существует");
        }

        userProfileRepository.save(userProfile);
    }

    @Override
    public void validateNickname(String nickname) {
        if (userProfileRepository.existsByNickname(nickname)) {
            throw new UserProfileServiceException("Данный никнейм уже занят другим пользователем");
        }
    }
}
