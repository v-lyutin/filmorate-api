package com.filmorate.filmorateapi.media.actor.repository;

import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
    Page<MovieActor> findAllByMovie(Pageable pageable, Movie movie);

    Page<MovieActor> findAllByMovieAndIsMainRole(Pageable pageable, Movie movie, Boolean isMainRole);

    void deleteAllByMovie(Movie movie);
}
