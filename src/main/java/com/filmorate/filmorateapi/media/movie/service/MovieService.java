package com.filmorate.filmorateapi.media.movie.service;

import com.filmorate.filmorateapi.media.movie.model.Movie;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void deleteMovieById(Long movieId);

    Movie getMovieById(Long movieId);
}
