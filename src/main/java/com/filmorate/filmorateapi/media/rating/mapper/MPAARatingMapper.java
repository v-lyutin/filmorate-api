package com.filmorate.filmorateapi.media.rating.mapper;

import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;

public interface MPAARatingMapper {
    MPAARating map(RatingCreationRequest request);

    void update(MPAARating mpaaRating, RatingUpdateRequest request);

    RatingResponse map(MPAARating mpaaRating);
}
