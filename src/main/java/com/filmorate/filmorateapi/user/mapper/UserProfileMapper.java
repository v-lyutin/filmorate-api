package com.filmorate.filmorateapi.user.mapper;

import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfilePreviewResponse;

public interface UserProfileMapper {
    UserProfilePreviewResponse toUserProfilePreviewResponse(UserProfile userProfile);
}
