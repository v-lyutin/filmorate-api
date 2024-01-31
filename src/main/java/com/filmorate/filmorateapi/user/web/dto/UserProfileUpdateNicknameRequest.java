package com.filmorate.filmorateapi.user.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UserProfileUpdateNicknameRequest(
    @NotBlank
    String nickname
) {
}
