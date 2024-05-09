package com.filmorate.filmorateapi.media.rating.service;

import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import java.util.List;

public interface MPAARatingService {
    MPAARating createMPAARating(MPAARating mpaa);

    MPAARating updateMPAARating(MPAARating mpaa);

    MPAARating getMPAARatingById(Long mpaaId);

    List<MPAARating> getAllMPAARatings();

    void removeMPAARatingById(Long mpaaId);

    MPAARating getByName(String name);
}
