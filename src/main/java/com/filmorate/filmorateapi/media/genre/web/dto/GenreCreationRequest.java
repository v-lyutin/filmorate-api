package com.filmorate.filmorateapi.media.genre.web.dto;

import jakarta.validation.constraints.NotBlank;

public record GenreCreationRequest(
        @NotBlank
        String name) {
}
