package com.filmorate.filmorateapi.media.compilation.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

public record CompilationCreationRequest(
        @NotBlank(message = "The 'title' field should not be an empty")
        @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
        String title,

        @Size(max = 1000, message = "The size of the 'description' field must not exceed 32 characters")
        String description,

        @NotEmpty(message = "The 'genres' field should not be an empty")
        Set<String> genres) {
}
