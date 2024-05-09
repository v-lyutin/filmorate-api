package com.filmorate.filmorateapi.media.rating.mapper;

import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;

public interface RARSRatingMapper {
    RARSRating map(RatingCreationRequest request);

    void update(RARSRating rarsRating, RatingUpdateRequest request);

    RatingResponse map(RARSRating rarsRating);
}
