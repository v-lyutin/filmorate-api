package com.filmorate.filmorateapi.media.movie.usecase.user;

import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import java.util.List;

public interface MovieUserProfileUseCase {
    List<MoviePreviewResponse> getFavoriteMovies();

    void toggleFavoriteMovie(Long movieId);
}
