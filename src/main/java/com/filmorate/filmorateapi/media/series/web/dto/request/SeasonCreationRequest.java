package com.filmorate.filmorateapi.media.series.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SeasonCreationRequest(
        @NotBlank(message = "The 'previewUrl' field should not be an empty")
        String posterUrl,

        @NotNull(message = "The 'seasonNumber' field should not be an empty")
        @Positive(message = "The 'seasonNumber' field must be a positive number and not equal to zero")
        Integer seasonNumber) {
}
