package com.filmorate.filmorateapi.user.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UserProfileRegisterRequest(
        @NotBlank
        String nickname,
        String imageLink
) {
}
