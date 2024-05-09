package com.filmorate.filmorateapi.media.rating.repository;

import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPAARatingRepository extends JpaRepository<MPAARating, Long> {
    boolean existsByNameContainingIgnoreCase(String name);

    MPAARating findByName(String name);
}
