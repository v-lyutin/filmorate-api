package com.filmorate.filmorateapi.media.movie.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;

public interface MovieToMovieCreationResponseMapper extends Mapper<MovieCreationResponse, Movie> {
}
