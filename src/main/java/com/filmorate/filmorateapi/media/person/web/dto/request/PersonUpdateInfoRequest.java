package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Date;

public record PersonUpdateInfoRequest(
        @NotBlank
        JsonNullable<String> firstName,

        @NotBlank
        JsonNullable<String> lastName,

        @NotNull
        @PastOrPresent(message = "Дата рождения из будущего")
        @JsonFormat(pattern = "yyyy-MM-dd")
        JsonNullable<Date> birthDate,

        @NotBlank
        JsonNullable<String> countryOfBirth,

        @NotBlank
        JsonNullable<String> cityOfBirth,

        @NotNull
        JsonNullable<Integer> height) {
}
