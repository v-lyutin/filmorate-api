package com.filmorate.filmorateapi.media.rating.repository;

import com.filmorate.filmorateapi.media.rating.model.MPAA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPAARepository extends JpaRepository<MPAA, Long> {
}
