package com.filmorate.filmorateapi.media.person.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.util.Date;

public record PersonCreationRequest(
        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotNull
        @PastOrPresent(message = "Дата рождения из будущего")
        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        @NotNull
        Integer height) {
}
