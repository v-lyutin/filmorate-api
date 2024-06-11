package com.filmorate.filmorateapi.media.movie.service;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    void deleteMovieById(Long movieId);

    Movie getMovieById(Long movieId);

    boolean existsById(Long movieId);

    Page<Movie> searchMovies(MovieFilter movieFilter, Pageable pageable);

    Page<Movie> getMostLikedMovies(Pageable pageable);

    void toggleLike(Long movieId);

    Long getMovieLikeCount(Long movieId);
}
