package com.filmorate.filmorateapi.user.usecase.favourites.impl;

import com.filmorate.filmorateapi.media.movie.api.MovieApiService;
import com.filmorate.filmorateapi.media.movie.mapper.MovieMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.person.api.PersonApiService;
import com.filmorate.filmorateapi.media.person.mapper.PersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.media.series.api.SeriesApiService;
import com.filmorate.filmorateapi.media.series.mapper.SeriesMapper;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.user.model.UserProfile;
import com.filmorate.filmorateapi.user.service.UserProfileService;
import com.filmorate.filmorateapi.user.usecase.favourites.FavouritesUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
@Transactional
@RequiredArgsConstructor
public class FavouritesUseCaseFacade implements FavouritesUseCase {
    private final UserProfileService userProfileService;
    private final PersonApiService personApiService;
    private final MovieApiService movieApiService;
    private final SeriesApiService seriesApiService;
    private final PersonMapper personMapper;
    private final MovieMapper movieMapper;
    private final SeriesMapper seriesMapper;

    @Override
    public List<PersonPreviewResponse> getFavoritePersons() {
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        return userProfile.getFavoritePersons().stream()
                .map(personMapper::toPersonPreviewResponse)
                .toList();
    }

    @Override
    public List<MoviePreviewResponse> getFavoriteMovies() {
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        return userProfile.getFavoriteMovies().stream()
                .map(movieMapper::toMoviePreviewResponse)
                .toList();
    }

    @Override
    public List<SeriesPreviewResponse> getFavoriteSeries() {
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        return userProfile.getFavoriteSeries().stream()
                .map(seriesMapper::toSeriesPreviewResponse)
                .toList();
    }

    @Override
    public void toggleFavoritePerson(Long personId) {
        Person person = personApiService.getPersonById(personId);
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        Set<Person> favouritePersons = userProfile.getFavoritePersons();
        if (favouritePersons.contains(person)) {
            favouritePersons.remove(person);
        } else {
            favouritePersons.add(person);
        }
        userProfileService.updateUserProfile(userProfile);
    }

    @Override
    public void toggleFavoriteMovie(Long movieId) {
        Movie movie = movieApiService.getMovieById(movieId);
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        Set<Movie> favouriteMovies = userProfile.getFavoriteMovies();
        if (favouriteMovies.contains(movie)) {
            favouriteMovies.remove(movie);
        } else {
            favouriteMovies.add(movie);
        }
        userProfileService.updateUserProfile(userProfile);
    }

    @Override
    public void toggleFavoriteSeries(Long seriesId) {
        Series series = seriesApiService.getSeriesById(seriesId);
        UserProfile userProfile = userProfileService.getCurrentUserProfile();
        Set<Series> favouriteSeries = userProfile.getFavoriteSeries();
        if (favouriteSeries.contains(series)) {
            favouriteSeries.remove(series);
        } else {
            favouriteSeries.add(series);
        }
        userProfileService.updateUserProfile(userProfile);
    }
}
