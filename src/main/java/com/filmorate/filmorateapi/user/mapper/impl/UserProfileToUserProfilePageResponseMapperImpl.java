package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileToUserProfilePageResponseMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.UserProfilePageResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileToUserProfilePageResponseMapperImpl implements UserProfileToUserProfilePageResponseMapper {
    @Override
    public UserProfilePageResponse map(UserProfile userProfile) {
        return new UserProfilePageResponse(userProfile.getNickname(), userProfile.getImageLink());
    }
}
