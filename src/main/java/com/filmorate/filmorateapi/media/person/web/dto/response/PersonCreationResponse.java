package com.filmorate.filmorateapi.media.person.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public record PersonCreationResponse(
        long id,

        String imageLink,

        String firstName,

        String lastName,

        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        String countryOfBirth,

        String cityOfBirth,

        int height) {
}
