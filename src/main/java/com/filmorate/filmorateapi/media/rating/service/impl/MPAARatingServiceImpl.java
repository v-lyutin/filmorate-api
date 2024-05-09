package com.filmorate.filmorateapi.media.rating.service.impl;

import com.filmorate.filmorateapi.media.rating.exception.RatingServiceException;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.repository.MPAARatingRepository;
import com.filmorate.filmorateapi.media.rating.service.MPAARatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MPAARatingServiceImpl implements MPAARatingService {
    private final MPAARatingRepository mpaaRatingRepository;

    @Override
    public MPAARating createMPAARating(MPAARating mpaa) {
        return mpaaRatingRepository.save(mpaa);
    }

    @Override
    public MPAARating updateMPAARating(MPAARating mpaa) {
        if (mpaaRatingRepository.existsByNameContainingIgnoreCase(mpaa.getName())) {
            throw new RatingServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("MPAA rating with name '%s' is already exists", mpaa.getName()));
        }
        return mpaaRatingRepository.save(mpaa);
    }

    @Override
    public MPAARating getMPAARatingById(Long mpaaId) {
        return mpaaRatingRepository.findById(mpaaId)
                .orElseThrow(() -> new RatingServiceException(
                        HttpStatus.BAD_REQUEST,
                        String.format("MPAA rating with ID '%d' not found", mpaaId)));
    }

    @Override
    public List<MPAARating> getAllMPAARatings() {
        return mpaaRatingRepository.findAll();
    }

    @Override
    public void removeMPAARatingById(Long mpaaId) {
        mpaaRatingRepository.deleteById(mpaaId);
    }

    @Override
    public MPAARating getByName(String name) {
        MPAARating mpaaRating = mpaaRatingRepository.findByName(name);
        if (mpaaRating == null) {
            throw new RatingServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("MPAA rating with name '%s' not found", name));
        }
        return mpaaRating;
    }
}
