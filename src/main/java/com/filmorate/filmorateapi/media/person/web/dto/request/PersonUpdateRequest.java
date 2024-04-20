package com.filmorate.filmorateapi.media.person.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Date;
import java.util.Set;

public record PersonUpdateRequest(
        JsonNullable<String> imageLink,

        @Size(max = 32, message = "The size of the 'name' field must not exceed 32 characters")
        JsonNullable<String> name,

        @Size(max = 32, message = "The size of the 'enName' field must not exceed 32 characters")
        JsonNullable<String> enName,

        @PastOrPresent(message = "Date of birth from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        JsonNullable<Date> birthDate,

        @Size(max = 32, message = "The size of the 'countryOfBirth' field must not exceed 32 characters")
        JsonNullable<String> countryOfBirth,

        @Size(max = 32, message = "The size of the 'cityOfBirth' field must not exceed 32 characters")
        JsonNullable<String> cityOfBirth,

        @Positive(message = "The height must be a positive number and not equal to zero")
        JsonNullable<Integer> height,

        JsonNullable<Set<String>> careers) {
}
