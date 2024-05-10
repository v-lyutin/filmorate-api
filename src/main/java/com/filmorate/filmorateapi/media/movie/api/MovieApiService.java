package com.filmorate.filmorateapi.media.movie.api;

import com.filmorate.filmorateapi.media.movie.model.Movie;

public interface MovieApiService {
    Movie getMovieById(Long movieId);
}
