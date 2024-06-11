package com.filmorate.filmorateapi.media.movie.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.movie.usecase.MovieCommonUseCase;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieCreationRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieFindRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieUpdateRequest;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieCreationResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MovieResponse;
import com.filmorate.filmorateapi.media.movie.web.dto.response.MoviesPageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movies")
public class MovieController {
    private final MovieCommonUseCase movieCommonUseCase;

    @GetMapping(value = "search")
    public MoviesPageResponse searchMovies(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "limit", defaultValue = "10") int limit,
                                           @Valid @RequestBody MovieFindRequest request) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return movieCommonUseCase.getMoviesWithFilters(request, pageFindRequest);
    }

    @GetMapping(value = "most-liked")
    public MoviesPageResponse getMostLikedMovies(@RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        return movieCommonUseCase.getMostLikedMovies(pageFindRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public MovieCreationResponse createMovie(@Valid @RequestBody MovieCreationRequest request) {
        return movieCommonUseCase.createMovie(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping(value = "{movieId:\\d+}")
    public MovieCreationResponse updateMovie(@PathVariable(name = "movieId") Long movieId,
                                             @Valid @RequestBody MovieUpdateRequest request) {
        return movieCommonUseCase.updateMovie(movieId, request);
    }

    @GetMapping(value = "{movieId:\\d+}")
    public MovieResponse getMovieById(@PathVariable(name = "movieId") Long movieId) {
        return movieCommonUseCase.getMovieById(movieId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "{movieId:\\d+}")
    public void removeMovieById(@PathVariable(name = "movieId") Long movieId) {
        movieCommonUseCase.removeMovieById(movieId);
    }

    @PostMapping(value = "{movieId:\\d+}/like")
    public void toggleLike(@PathVariable(name = "movieId") Long movieId) {
        movieCommonUseCase.toggleLike(movieId);
    }
}
