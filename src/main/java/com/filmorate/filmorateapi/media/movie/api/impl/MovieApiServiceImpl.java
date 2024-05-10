package com.filmorate.filmorateapi.media.movie.api.impl;

import com.filmorate.filmorateapi.media.movie.api.MovieApiService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieApiServiceImpl implements MovieApiService {
    private final MovieService movieService;

    @Override
    public Movie getMovieById(Long movieId) {
        return movieService.getMovieById(movieId);
    }
}
