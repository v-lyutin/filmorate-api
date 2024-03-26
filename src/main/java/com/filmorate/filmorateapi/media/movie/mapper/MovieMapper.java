package com.filmorate.filmorateapi.media.movie.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;

public interface MovieMapper extends Mapper<Movie, MovieCreationRequest> {
    MovieCreationResponse map(Movie movie);

    Movie map(MovieCreationRequest request);

    MovieResponse toMovieResponse(Movie movie);
}