package com.filmorate.filmorateapi.media.rating.usecase.impl;

import com.filmorate.filmorateapi.media.rating.mapper.MPAARatingMapper;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.service.MPAARatingService;
import com.filmorate.filmorateapi.media.rating.usecase.RatingUseCase;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingCreationRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.request.RatingUpdateRequest;
import com.filmorate.filmorateapi.media.rating.web.dto.response.RatingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MPAARatingUseCase implements RatingUseCase {
    private final MPAARatingService mpaaRatingService;
    private final MPAARatingMapper mpaaRatingMapper;

    @Override
    public RatingResponse createRating(RatingCreationRequest request) {
        MPAARating mpaaRating = mpaaRatingService.createMPAARating(mpaaRatingMapper.map(request));
        return mpaaRatingMapper.map(mpaaRating);
    }

    @Override
    public RatingResponse updateRating(Long ratingId, RatingUpdateRequest request) {
        MPAARating mpaaRating = mpaaRatingService.getMPAARatingById(ratingId);
        mpaaRatingMapper.update(mpaaRating, request);
        return mpaaRatingMapper.map(mpaaRatingService.updateMPAARating(mpaaRating));
    }

    @Override
    public RatingResponse getRating(Long ratingId) {
        return mpaaRatingMapper.map(mpaaRatingService.getMPAARatingById(ratingId));
    }

    @Override
    public List<RatingResponse> getAllRatings() {
        return mpaaRatingService.getAllMPAARatings().stream()
                .map(mpaaRatingMapper::map)
                .toList();
    }

    @Override
    public void removeRating(Long ratingId) {
        mpaaRatingService.removeMPAARatingById(ratingId);
    }
}
