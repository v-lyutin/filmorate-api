package com.filmorate.filmorateapi.media.movie.web;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.usecase.MovieCommonUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movies")
public class MovieController {
    private final MovieCommonUseCase movieCommonUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieCreationResponse createMovie(@Valid @RequestBody MovieCreationRequest request) {
        return movieCommonUseCase.createMovie(request);
    }

    @GetMapping("{movieId:\\d+}")
    public Movie getMovieById(@PathVariable(name = "movieId") Long movieId) {
        return movieCommonUseCase.getMovieById(movieId);
    }

    @DeleteMapping("{movieId:\\d+}")
    public void removeMovieById(@PathVariable(name = "movieId") Long movieId) {
        movieCommonUseCase.removeMovieById(movieId);
    }
}
