package com.filmorate.filmorateapi.media.person.web.dto;

import jakarta.validation.constraints.NotBlank;

public record PersonAddImageLinkRequest(
        @NotBlank
        String imageLink) {
}
