package com.filmorate.filmorateapi.media.actor.service;

import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MovieActorService {
    List<MovieActor> createActors(List<MovieActor> actors);

    MovieActor updateActor(MovieActor actor);

    MovieActor getActorById(Long actorId);

    Page<MovieActor> getActorsByMovie(Pageable pageable, Movie movie);

    Page<MovieActor> getActorsByMovieAndIsMainRole(Pageable pageable, Movie movie, Boolean isMainRole);

    void removeActorById(Long actorId);

    void removeAllActorsByMovie(Movie movie);
}
