package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import com.filmorate.filmorateapi.user.usecase.favourites.FavouritesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class FavouritesController {
    private final FavouritesUseCase favouritesUseCase;

    @GetMapping(value = "profiles/myProfile/favourites/persons")
    public List<PersonPreviewResponse> getFavoritePersons() {
        return favouritesUseCase.getFavoritePersons();
    }

    @GetMapping(value = "profiles/myProfile/favourites/movies")
    public List<MoviePreviewResponse> getFavoriteMovies() {
        return favouritesUseCase.getFavoriteMovies();
    }

    @GetMapping(value = "profiles/myProfile/favourites/series")
    public List<SeriesPreviewResponse> getFavoriteSeries() {
        return favouritesUseCase.getFavoriteSeries();
    }

    @PostMapping(value = "persons/{personId:\\d+}/favourites")
    public void toggleFavoritePerson(@PathVariable(name = "personId") Long personId) {
        favouritesUseCase.toggleFavoritePerson(personId);
    }

    @PostMapping(value = "movies/{movieId:\\d+}/favourites")
    public void toggleFavoriteMovie(@PathVariable(name = "movieId") Long movieId) {
        favouritesUseCase.toggleFavoriteMovie(movieId);
    }

    @PostMapping(value = "series/{seriesId:\\d+}/favourites")
    public void toggleFavoriteSeries(@PathVariable(name = "seriesId") Long seriesId) {
        favouritesUseCase.toggleFavoriteSeries(seriesId);
    }
}
