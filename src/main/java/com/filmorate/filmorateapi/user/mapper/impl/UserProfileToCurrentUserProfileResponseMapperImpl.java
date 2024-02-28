package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileToCurrentUserProfileResponseMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileToCurrentUserProfileResponseMapperImpl implements UserProfileToCurrentUserProfileResponseMapper {
    @Override
    public CurrentUserProfileResponse map(UserProfile userProfile) {
        return new CurrentUserProfileResponse(
                userProfile.getImageLink(),
                userProfile.getNickname(),
                userProfile.getCreatedAt());
    }
}
