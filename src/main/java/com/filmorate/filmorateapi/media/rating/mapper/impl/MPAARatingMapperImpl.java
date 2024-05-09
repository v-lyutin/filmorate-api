package com.filmorate.filmorateapi.media.rating.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.rating.mapper.MPAARatingMapper;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MPAARatingMapperImpl implements MPAARatingMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public MPAARating map(RatingCreationRequest request) {
        return MPAARating.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    @Override
    public void update(MPAARating mpaaRating, RatingUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.name())) {
                mpaaRating.setName(jsonNullableMapper.unwrap(request.name()));
            }
            if (jsonNullableMapper.isPresent(request.name())) {
                mpaaRating.setDescription(jsonNullableMapper.unwrap(request.description()));
            }
        }
    }

    @Override
    public RatingResponse map(MPAARating mpaaRating) {
        return new RatingResponse(
                mpaaRating.getId(),
                mpaaRating.getName(),
                mpaaRating.getDescription()
        );
    }
}
