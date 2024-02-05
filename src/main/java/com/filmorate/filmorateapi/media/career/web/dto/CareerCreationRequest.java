package com.filmorate.filmorateapi.media.career.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CareerCreationRequest(
        @NotBlank
        String name) {
}
