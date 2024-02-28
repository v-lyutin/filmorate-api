package com.filmorate.filmorateapi.security.web.dto.request;

import com.filmorate.filmorateapi.security.validation.Password;

public record PasswordRequest(
        @Password
        String newPassword,

        String oldPassword) {
}
