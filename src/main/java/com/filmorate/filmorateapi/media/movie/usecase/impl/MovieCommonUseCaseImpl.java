package com.filmorate.filmorateapi.media.movie.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.usecase.MovieCommonUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviesPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieCommonUseCaseImpl implements MovieCommonUseCase {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Override
    public MovieCreationResponse createMovie(MovieCreationRequest request) {
        Movie movie = movieMapper.map(request);
        return movieMapper.map(movieService.createMovie(movie));
    }

    @Override
    public MovieResponse getMovieById(Long movieId) {
        return movieMapper.toMovieResponse(movieService.getMovieById(movieId));
    }

    @Override
    public void removeMovieById(Long movieId) {
        movieService.deleteMovieById(movieId);
    }

    @Override
    public MoviesPageResponse getMoviesWithFilters(MovieFilter movieFilter, PageFindRequest request) {
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<Movie> movies = movieService.getMoviesWithFilters(movieFilter, pageable);
        return movieMapper.toMoviesPageResponse(movies);
    }
}

