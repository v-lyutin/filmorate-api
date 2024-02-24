package com.filmorate.filmorateapi.media.fact.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FactAddRequest(
        @NotBlank
        @Size(min = 10, max = 300)
        String text) {
}
