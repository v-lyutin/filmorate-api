package com.filmorate.filmorateapi.media.rating.service;

import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import java.util.List;

public interface RARSRatingService {
    RARSRating createRARSRating(RARSRating rars);

    RARSRating updateRARSRating(RARSRating rars);

    RARSRating getRARSRatingById(Long rarsId);

    List<RARSRating> getAllRARSRatings();

    void removeRARSRatingById(Long rarsId);

    RARSRating getByName(String name);
}
