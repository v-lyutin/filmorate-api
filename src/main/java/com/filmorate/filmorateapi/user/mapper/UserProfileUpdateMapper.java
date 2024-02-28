package com.filmorate.filmorateapi.user.mapper;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserProfileUpdateMapper {
    public abstract void map(UserProfileUpdateRequest request, @MappingTarget UserProfile userProfile);
}
