package com.filmorate.filmorateapi.media.movie.service.impl;

import com.filmorate.filmorateapi.media.movie.exception.MovieServiceException;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.repository.MovieRepository;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final CurrentUserProfileApiService currentUserProfileApiService;

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

    @Override
    @Transactional
    public void toggleLike(Long movieId) {
        Movie movie = getMovieById(movieId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Set<UserProfile> likes = movie.getLikedByUsers();
        if (likes.contains(userProfile)) {
            likes.remove(userProfile);
        } else {
            likes.add(userProfile);
        }
        movieRepository.save(movie);
    }

    @Override
    public Long getMovieLikeCount(Long movieId) {
        return movieRepository.getMovieLikeCount(movieId);
    }
}
