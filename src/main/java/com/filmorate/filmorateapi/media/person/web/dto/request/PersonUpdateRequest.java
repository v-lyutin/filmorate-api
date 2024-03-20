package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Date;

public record PersonUpdateRequest(
        JsonNullable<String> imageLink,

        JsonNullable<String> name,

        @PastOrPresent(message = "Date of birth from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        JsonNullable<Date> birthDate,

        JsonNullable<String> countryOfBirth,

        JsonNullable<String> cityOfBirth,

        @Positive(message = "The height must be a positive number and not equal to zero")
        JsonNullable<Integer> height) {
}
