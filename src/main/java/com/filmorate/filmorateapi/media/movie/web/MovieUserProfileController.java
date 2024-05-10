package com.filmorate.filmorateapi.media.movie.web;

import com.filmorate.filmorateapi.media.movie.usecase.user.MovieUserProfileUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviePreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MovieUserProfileController {
    private final MovieUserProfileUseCase movieUserProfileUseCase;

    @PostMapping(value = "movies/{movieId:\\d+}/favorites")
    public void toggleFavoriteMovie(@PathVariable("movieId") Long movieId) {
        movieUserProfileUseCase.toggleFavoriteMovie(movieId);
    }

    @GetMapping(value = "profiles/myProfile/favoriteMovies")
    public List<MoviePreviewResponse> getFavoriteMovies() {
        return movieUserProfileUseCase.getFavoriteMovies();
    }
}
