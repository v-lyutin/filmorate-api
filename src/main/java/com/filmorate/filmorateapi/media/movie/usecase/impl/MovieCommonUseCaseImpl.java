package com.filmorate.filmorateapi.media.movie.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.movie.mapper.MovieFilterMapper;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.usecase.MovieCommonUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieFindRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieUpdateRequest;
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
    private final MovieFilterMapper movieFilterMapper;

    @Override
    public MovieCreationResponse createMovie(MovieCreationRequest request) {
        Movie movie = movieMapper.map(request);
        return movieMapper.map(movieService.createMovie(movie));
    }

    @Override
    public MovieCreationResponse updateMovie(Long movieId, MovieUpdateRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        movieMapper.update(movie, request);
        return movieMapper.map(movieService.updateMovie(movie));
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
    public MoviesPageResponse getMoviesWithFilters(MovieFindRequest movieFindRequest, PageFindRequest pageFindRequest) {
        Pageable pageable = PageRequest.of(pageFindRequest.page(), pageFindRequest.limit());
        MovieFilter movieFilter = movieFilterMapper.map(movieFindRequest);
        Page<Movie> movies = movieService.searchMovies(movieFilter, pageable);
        return movieMapper.toMoviesPageResponse(movies);
    }

    @Override
    public MoviesPageResponse getMostLikedMovies(PageFindRequest pageFindRequest) {
        Pageable pageable = PageRequest.of(pageFindRequest.page(), pageFindRequest.limit());
        Page<Movie> movies = movieService.getMostLikedMovies(pageable);
        return movieMapper.toMoviesPageResponse(movies);
    }

    @Override
    public void toggleLike(Long movieId) {
        movieService.toggleLike(movieId);
    }
}

