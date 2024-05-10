package com.filmorate.filmorateapi.user.usecase.favourites;

import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.media.series.web.dto.response.SeriesPreviewResponse;
import java.util.List;

public interface FavouritesUseCase {
    List<PersonPreviewResponse> getFavoritePersons();

    List<MoviePreviewResponse> getFavoriteMovies();

    List<SeriesPreviewResponse> getFavoriteSeries();

    void toggleFavoritePerson(Long personId);

    void toggleFavoriteMovie(Long movieId);

    void toggleFavoriteSeries(Long seriesId);
}
