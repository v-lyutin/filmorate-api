package com.filmorate.filmorateapi.media.genre.repository;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    boolean existsByName(String name);
}
