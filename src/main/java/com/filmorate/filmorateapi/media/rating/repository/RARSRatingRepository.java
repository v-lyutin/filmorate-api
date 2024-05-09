package com.filmorate.filmorateapi.media.rating.repository;

import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RARSRatingRepository extends JpaRepository<RARSRating, Long> {
    boolean existsByNameContainingIgnoreCase(String name);

    RARSRating findByName(String name);
}
