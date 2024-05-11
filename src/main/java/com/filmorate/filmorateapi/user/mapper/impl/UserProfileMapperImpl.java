package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.user.mapper.UserProfileMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public UserProfilePreviewResponse toUserProfilePreviewResponse(UserProfile userProfile) {
        return new UserProfilePreviewResponse(
                userProfile.getId(),
                userProfile.getImageLink(),
                userProfile.getNickname()
        );
    }
}
