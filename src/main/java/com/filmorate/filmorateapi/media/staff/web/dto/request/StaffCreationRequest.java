package com.filmorate.filmorateapi.media.staff.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StaffCreationRequest(
        @NotNull(message = "The 'personId' field should not be an empty")
        Long personId,

        @NotBlank(message = "The 'staffRole' field should not be an empty")
        String staffRole) {
}
