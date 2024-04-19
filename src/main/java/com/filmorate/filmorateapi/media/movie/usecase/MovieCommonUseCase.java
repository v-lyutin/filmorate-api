package com.filmorate.filmorateapi.media.movie.usecase;

import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;

public interface MovieCommonUseCase {
    MovieCreationResponse createMovie(MovieCreationRequest request);

    MovieResponse getMovieById(Long movieId);

    void removeMovieById(Long movieId);
}
