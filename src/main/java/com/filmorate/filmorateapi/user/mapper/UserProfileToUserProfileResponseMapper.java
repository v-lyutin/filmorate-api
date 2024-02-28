package com.filmorate.filmorateapi.user.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.UserProfileResponse;

public interface UserProfileToUserProfileResponseMapper extends Mapper<UserProfileResponse, UserProfile> {
}
