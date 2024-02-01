package com.filmorate.filmorateapi.security.web.dto;

import com.filmorate.filmorateapi.security.validation.ValidPassword;

public record PasswordRequest(
        @ValidPassword
        String newPassword,

        String oldPassword
) {
}
