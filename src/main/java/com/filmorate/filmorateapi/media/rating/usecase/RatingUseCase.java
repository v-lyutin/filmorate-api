package com.filmorate.filmorateapi.media.rating.usecase;

import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import java.util.List;

public interface RatingUseCase {
    RatingResponse createRating(RatingCreationRequest request);

    RatingResponse updateRating(Long ratingId, RatingUpdateRequest request);

    RatingResponse getRating(Long ratingId);

    List<RatingResponse> getAllRatings();

    void removeRating(Long ratingId);
}
