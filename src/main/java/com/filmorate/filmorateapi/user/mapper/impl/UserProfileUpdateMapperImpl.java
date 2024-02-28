package com.filmorate.filmorateapi.user.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.user.mapper.UserProfileUpdateMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProfileUpdateMapperImpl extends UserProfileUpdateMapper {
    private final JsonNullableMapper jsonNullableMapper;
    private final UserProfileService userProfileService;

    @Override
    public void map(UserProfileUpdateRequest request, UserProfile userProfile) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.imageLink())) {
            userProfile.setImageLink(jsonNullableMapper.unwrap(request.imageLink()));
        }
        if (jsonNullableMapper.isPresent(request.nickname())) {
            userProfileService.validateNickname(request.nickname().get());
            userProfile.setNickname(jsonNullableMapper.unwrap(request.nickname()));
        }
    }
}
