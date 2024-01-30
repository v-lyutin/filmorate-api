package com.filmorate.filmorateapi.security.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(min = 8, max = 20)
        String password
) {}
