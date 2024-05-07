package com.filmorate.filmorateapi.media.movie.service.impl;

import com.filmorate.filmorateapi.media.movie.exception.MovieServiceException;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.repository.MovieRepository;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Movie with ID = %d not found", movieId))
                );
    }

    @Override
    public boolean existsById(Long movieId) {
        return movieRepository.existsById(movieId);
    }

    @Override
    public Page<Movie> getMoviesWithFilters(MovieFilter movieFilter, Pageable pageable) {
        return movieRepository.findAll(movieFilter, pageable);
    }
}
