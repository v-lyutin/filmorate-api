package com.filmorate.filmorateapi.media.genre.web;

import com.filmorate.filmorateapi.media.genre.usecase.GenreUseCase;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {
    private final GenreUseCase genreUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Collection<GenreResponse> getAllGenres() {
        return genreUseCase.getAllGenres();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void createGenre(@Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.createGenre(request);
    }

    @PutMapping(value = "/{genreId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateGenre(@PathVariable Long genreId, @Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.updateGenre(genreId, request);
    }

    @DeleteMapping(value = "/{genreId}")
    void deleteGenre(@PathVariable Long genreId) {
        genreUseCase.deleteGenre(genreId);
    }
}
