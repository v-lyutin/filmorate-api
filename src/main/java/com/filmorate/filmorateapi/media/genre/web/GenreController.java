package com.filmorate.filmorateapi.media.genre.web;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.usecase.GenreUseCase;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class GenreController {
    private final GenreUseCase genreUseCase;

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    Collection<Genre> getAllGenres() {
        return genreUseCase.getAllGenres();
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @GetMapping(value = "/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Genre getGenreById(@PathVariable Long genreId) {
        return genreUseCase.getGenreById(genreId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void createGenre(@Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.createGenre(request);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping(value = "/{genreId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateGenre(@PathVariable Long genreId, @Valid @RequestBody GenreCreationRequest request) {
        genreUseCase.updateGenre(genreId, request);
    }

    @DeleteMapping(value = "/{genreId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    void deleteGenre(@PathVariable Long genreId) {
        genreUseCase.deleteGenre(genreId);
    }
}
