package com.filmorate.filmorateapi.media.genre.web;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.usecase.GenreUseCase;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/genres")
public class GenreController {
    private final GenreUseCase genreUseCase;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Collection<Genre> getAllGenres() {
        return genreUseCase.getAllGenres();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Genre getGenreById(@PathVariable Long genreId) {
        return genreUseCase.getGenreById(genreId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void createGenre(@Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.createGenre(request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{genreId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateGenre(@PathVariable Long genreId, @Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.updateGenre(genreId, request);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{genreId}")
    void deleteGenre(@PathVariable Long genreId) {
        genreUseCase.deleteGenre(genreId);
    }
}
