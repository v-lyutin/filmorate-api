package com.filmorate.filmorateapi.media.rating.usecase.impl;

import com.filmorate.filmorateapi.media.rating.mapper.RARSRatingMapper;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.service.RARSRatingService;
import com.filmorate.filmorateapi.media.rating.usecase.RatingUseCase;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RARSRatingUseCase implements RatingUseCase {
    private final RARSRatingService rarsRatingService;
    private final RARSRatingMapper rarsRatingMapper;

    @Override
    public RatingResponse createRating(RatingCreationRequest request) {
        RARSRating rarsRating = rarsRatingService.createRARSRating(rarsRatingMapper.map(request));
        return rarsRatingMapper.map(rarsRating);
    }

    @Override
    public RatingResponse updateRating(Long ratingId, RatingUpdateRequest request) {
        RARSRating rarsRating = rarsRatingService.getRARSRatingById(ratingId);
        rarsRatingMapper.update(rarsRating, request);
        return rarsRatingMapper.map(rarsRatingService.updateRARSRating(rarsRating));
    }

    @Override
    public RatingResponse getRating(Long ratingId) {
        return rarsRatingMapper.map(rarsRatingService.getRARSRatingById(ratingId));
    }

    @Override
    public List<RatingResponse> getAllRatings() {
        return rarsRatingService.getAllRARSRatings().stream()
                .map(rarsRatingMapper::map)
                .toList();
    }

    @Override
    public void removeRating(Long ratingId) {
        rarsRatingService.removeRARSRatingById(ratingId);
    }
}
