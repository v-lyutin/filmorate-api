package com.filmorate.filmorateapi.media.movie.usecase.user.impl;

import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.movie.usecase.user.MovieUserProfileUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@RequiredArgsConstructor
public class MovieUserProfileUseCaseFacade implements MovieUserProfileUseCase {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public List<MoviePreviewResponse> getFavoriteMovies() {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        return userProfile.getFavoriteMovies().stream()
                .map(movieMapper::toMoviePreviewResponse)
                .toList();
    }

    @Override
    public void toggleFavoriteMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Set<Movie> favouriteMovies = userProfile.getFavoriteMovies();
        if (favouriteMovies.contains(movie)) {
            favouriteMovies.remove(movie);
        } else {
            favouriteMovies.add(movie);
        }
        currentUserProfileApiService.updateUserProfile(userProfile);
    }
}
