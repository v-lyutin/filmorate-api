package com.filmorate.filmorateapi.media.actor.service.impl;

import com.filmorate.filmorateapi.media.actor.exception.MovieActorServiceException;
import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.actor.repository.MovieActorRepository;
import com.filmorate.filmorateapi.media.actor.service.MovieActorService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieActorServiceImpl implements MovieActorService {
    private final MovieActorRepository movieActorRepository;

    @Override
    public List<MovieActor> createActors(List<MovieActor> actors) {
        return movieActorRepository.saveAll(actors);
    }

    @Override
    public MovieActor updateActor(MovieActor actor) {
        return movieActorRepository.save(actor);
    }

    @Override
    public MovieActor getActorById(Long actorId) {
        return movieActorRepository.findById(actorId)
                .orElseThrow(() -> new MovieActorServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Actor with ID = '%d' not found", actorId)));
    }

    @Override
    public Page<MovieActor> getActorsByMovie(Pageable pageable, Movie movie) {
        return movieActorRepository.findAllByMovie(pageable, movie);
    }

    @Override
    public Page<MovieActor> getActorsByMovieAndIsMainRole(Pageable pageable, Movie movie, Boolean isMainRole) {
        return movieActorRepository.findAllByMovieAndIsMainRole(pageable, movie, isMainRole);
    }

    @Override
    public void removeActorById(Long actorId) {
        movieActorRepository.deleteById(actorId);
    }

    @Override
    public void removeAllActorsByMovie(Movie movie) {
        movieActorRepository.deleteAllByMovie(movie);
    }
}
