package com.filmorate.filmorateapi.media.actor.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.actor.mapper.MovieActorMapper;
import com.filmorate.filmorateapi.media.actor.model.MovieActor;
import com.filmorate.filmorateapi.media.actor.service.MovieActorService;
import com.filmorate.filmorateapi.media.actor.usecase.MovieActorUseCase;
import com.filmorate.filmorateapi.media.actor.web.dto.request.MovieActorCreationRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.request.MovieActorUpdateRequest;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorPageResponse;
import com.filmorate.filmorateapi.media.actor.web.dto.response.MovieActorResponse;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieActorUseCaseImpl implements MovieActorUseCase {
    private final MovieActorService movieActorService;
    private final MovieService movieService;
    private final MovieActorMapper movieActorMapper;

    @Override
    public List<MovieActorResponse> createActors(Long movieId, List<MovieActorCreationRequest> request) {
        Movie movie = movieService.getMovieById(movieId);
        List<MovieActor> createdActors = movieActorService.createActors(movieActorMapper.map(movie, request));
        return movieActorMapper.map(createdActors);
    }

    @Override
    public MovieActorResponse updateActorById(Long actorId, MovieActorUpdateRequest request) {
        MovieActor actor = movieActorService.getActorById(actorId);
        movieActorMapper.update(actor, request);
        movieActorService.updateActor(actor);
        return movieActorMapper.map(actor);
    }

    @Override
    public MovieActorPageResponse getActorsByMovie(Long movieId, PageFindRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<MovieActor> pageableActors = movieActorService.getActorsByMovie(pageable, movie);
        return movieActorMapper.map(pageableActors);
    }

    @Override
    public MovieActorResponse getActorById(Long actorId) {
        return movieActorMapper.map(movieActorService.getActorById(actorId));
    }

    @Override
    public void removeActorById(Long actorId) {
        movieActorService.removeActorById(actorId);
    }

    @Override
    public void removeAllActorsByMovieId(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        movieActorService.removeAllActorsByMovie(movie);
    }
}
