package com.filmorate.filmorateapi.media.person.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.Set;

public record PersonResponse(
        long id,

        String imageLink,

        String name,

        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        String countryOfBirth,

        String cityOfBirth,

        int height,

        Set<String> careers) {
}
