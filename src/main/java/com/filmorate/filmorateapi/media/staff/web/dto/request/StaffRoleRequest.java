package com.filmorate.filmorateapi.media.staff.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record StaffRoleRequest(
        @NotBlank(message = "The 'position' field should not be an empty")
        String position) {
}
