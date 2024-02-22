package com.filmorate.filmorateapi.user.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UserProfileUpdateImageLinkRequest(
        @NotBlank
        String imageLink) {
}
