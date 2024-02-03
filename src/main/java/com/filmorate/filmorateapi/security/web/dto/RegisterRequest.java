package com.filmorate.filmorateapi.security.web.dto;

import com.filmorate.filmorateapi.security.validation.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @Email
        @NotBlank
        String email,

        @Password
        String password) {
}
