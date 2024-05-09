package com.filmorate.filmorateapi.media.rating.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.rating.mapper.RARSRatingMapper;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RARSRatingMapperImpl implements RARSRatingMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public RARSRating map(RatingCreationRequest request) {
        return RARSRating.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    @Override
    public void update(RARSRating rarsRating, RatingUpdateRequest request) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.name())) {
            rarsRating.setName(jsonNullableMapper.unwrap(request.name()));
        }
        if (jsonNullableMapper.isPresent(request.name())) {
            rarsRating.setDescription(jsonNullableMapper.unwrap(request.description()));
        }
    }

    @Override
    public RatingResponse map(RARSRating rarsRating) {
        return new RatingResponse(
                rarsRating.getId(),
                rarsRating.getName(),
                rarsRating.getDescription()
        );
    }
}
