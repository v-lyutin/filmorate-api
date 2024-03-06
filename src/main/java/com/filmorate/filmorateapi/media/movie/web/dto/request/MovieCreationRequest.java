package com.filmorate.filmorateapi.media.movie.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MovieCreationRequest(
        @NotBlank(message = "Url name should not be an empty")
        String url,

        @NotBlank(message = "Poster url should not be an empty")
        String posterUrl,

        @NotBlank(message = "Name should not be an empty")
        String name,

        @NotBlank(message = "English name should not be an empty")
        String enName,

        @NotBlank(message = "Description should not be an empty")
        String description,

        @NotBlank(message = "English description should not be an empty")
        String enDescription,

        @NotNull(message = "Release year should not be an empty")
        @Positive(message = "Release year must be a positive number and not equal to zero")
        Integer releaseYear,

        @NotNull(message = "Duration should not be an empty")
        @Positive(message = "Duration must be a positive number and not equal to zero")
        Integer duration) {
}
