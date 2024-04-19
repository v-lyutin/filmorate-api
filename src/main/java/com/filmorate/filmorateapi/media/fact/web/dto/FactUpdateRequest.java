package com.filmorate.filmorateapi.media.fact.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FactUpdateRequest(
        @NotBlank(message = "The 'text' field should not be an empty")
        @Size(min = 10, max = 300)
        String text) {
}
