package com.filmorate.filmorateapi.media.movie.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviesPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MovieCommonUseCase {
    MovieCreationResponse createMovie(MovieCreationRequest request);

    MovieResponse getMovieById(Long movieId);

    void removeMovieById(Long movieId);

    MoviesPageResponse getMoviesWithFilters(MovieFilter movieFilter, @Valid  PageFindRequest request);
}
