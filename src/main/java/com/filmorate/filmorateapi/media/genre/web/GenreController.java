package com.filmorate.filmorateapi.media.genre.web;

import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.usecase.GenreUseCase;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreCreationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/genres")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class GenreController {
    private final GenreUseCase genreUseCase;

    @GetMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    Collection<Genre> getAllGenres() {
        return genreUseCase.getAllGenres();
    }

    @GetMapping(value = "{genreId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    Genre getGenreById(@PathVariable Long genreId) {
        return genreUseCase.getGenreById(genreId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    Genre createGenre(@Valid @RequestBody GenreCreationRequest request) {
        return genreUseCase.createGenre(request);
    }

    @PutMapping(value = "{genreId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    Genre updateGenre(@PathVariable Long genreId, @Valid @RequestBody GenreCreationRequest request) {
        return genreUseCase.updateGenre(genreId, request);
    }

    @DeleteMapping(value = "{genreId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    void deleteGenre(@PathVariable Long genreId) {
        genreUseCase.deleteGenre(genreId);
    }
}
