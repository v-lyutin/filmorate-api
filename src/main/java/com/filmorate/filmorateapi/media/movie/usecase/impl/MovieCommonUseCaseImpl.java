package com.filmorate.filmorateapi.media.movie.usecase.impl;

import com.filmorate.filmorateapi.media.movie.mapper.MovieCreationRequestToMovieMapper;
import com.filmorate.filmorateapi.media.movie.mapper.MovieToMovieCreationResponseMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.usecase.MovieCommonUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieCommonUseCaseImpl implements MovieCommonUseCase {
    private final MovieService movieService;
    private final MovieCreationRequestToMovieMapper movieCreationRequestToMovieMapper;
    private final MovieToMovieCreationResponseMapper movieToMovieCreationResponseMapper;

    @Override
    public MovieCreationResponse createMovie(MovieCreationRequest request) {
        Movie movie = movieCreationRequestToMovieMapper.map(request);
        return movieToMovieCreationResponseMapper.map(movieService.createMovie(movie));
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @Override
    public void removeMovieById(Long movieId) {
        movieService.deleteMovieById(movieId);
    }
}

