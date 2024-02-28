package com.filmorate.filmorateapi.user.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;

public interface UserProfileToCurrentUserProfileResponseMapper extends Mapper<CurrentUserProfileResponse, UserProfile> {
}
