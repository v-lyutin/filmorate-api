package com.filmorate.filmorateapi.media.rating.service.impl;

import com.filmorate.filmorateapi.media.rating.exception.RatingServiceException;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.repository.RARSRatingRepository;
import com.filmorate.filmorateapi.media.rating.service.RARSRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RARSRatingServiceImpl implements RARSRatingService {
    private final RARSRatingRepository rarsRatingRepository;

    @Override
    public RARSRating createRARSRating(RARSRating rars) {
        return rarsRatingRepository.save(rars);
    }

    @Override
    public RARSRating updateRARSRating(RARSRating rars) {
        if (rarsRatingRepository.existsByNameContainingIgnoreCase(rars.getName())) {
            throw new RatingServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("RARS rating with name '%s' is already exists", rars.getName()));
        }
        return rarsRatingRepository.save(rars);
    }

    @Override
    public RARSRating getRARSRatingById(Long rarsId) {
        return rarsRatingRepository.findById(rarsId)
                .orElseThrow(() -> new RatingServiceException(
                        HttpStatus.BAD_REQUEST,
                        String.format("RARS rating with ID '%d' not found", rarsId)));
    }

    @Override
    public List<RARSRating> getAllRARSRatings() {
        return rarsRatingRepository.findAll();
    }

    @Override
    public void removeRARSRatingById(Long rarsId) {
        rarsRatingRepository.deleteById(rarsId);
    }

    @Override
    public RARSRating getByName(String name) {
        RARSRating rarsRating = rarsRatingRepository.findByName(name);
        if (rarsRating == null) {
            throw new RatingServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("RARS rating with name '%s' not found", name));
        }
        return rarsRating;
    }
}
