package com.filmorate.filmorateapi.media.series.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record EpisodeCreationRequest(
        @NotBlank(message = "The 'previewUrl' field should not be an empty")
        String previewUrl,

        @NotBlank(message = "The 'title' field should not be an empty")
        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        String title,

        @NotBlank(message = "The 'originalTitle' field should not be an empty")
        @Size(max = 32, message = "The size of the 'originalTitle' field must not exceed 32 characters")
        String originalTitle,

        @NotNull(message = "The 'episodeNumber' field should not be an empty")
        @Positive(message = "The 'episodeNumber' field must be a positive number and not equal to zero")
        Integer episodeNumber,

        @NotBlank(message = "The 'description' field should not be an empty")
        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        String description,

        @NotNull(message = "The 'duration' field should not be an empty")
        @Positive(message = "The 'duration' field must be a positive number and not equal to zero")
        Integer duration,

        @NotNull(message = "The 'releaseDate' field should not be an empty")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date releaseDate) {
}
