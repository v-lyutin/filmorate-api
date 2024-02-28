package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileToUserProfileResponseMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.UserProfileResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileToUserProfileResponseMapperImpl implements UserProfileToUserProfileResponseMapper {
    @Override
    public UserProfileResponse map(UserProfile userProfile) {
        return new UserProfileResponse(
                userProfile.getImageLink(),
                userProfile.getNickname(),
                userProfile.getCreatedAt());
    }
}
