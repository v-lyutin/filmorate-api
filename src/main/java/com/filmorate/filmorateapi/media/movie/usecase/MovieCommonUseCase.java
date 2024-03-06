package com.filmorate.filmorateapi.media.movie.usecase;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;

public interface MovieCommonUseCase {
    MovieCreationResponse createMovie(MovieCreationRequest request);

    Movie getMovieById(Long movieId);

    void removeMovieById(Long movieId);
}
