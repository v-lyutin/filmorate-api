package com.filmorate.filmorateapi.media.person.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.fact.web.dto.FactDemoResponse;
import java.util.Collection;
import java.util.Date;

public record PersonResponse(
        long id,

        String imageLink,

        String firstName,

        String lastName,

        @JsonFormat(pattern = "yyyy-MM-dd")
        Date birthDate,

        String countryOfBirth,

        String cityOfBirth,

        int height,

        Collection<Career> careers,

        Collection<FactDemoResponse> facts) {
}
