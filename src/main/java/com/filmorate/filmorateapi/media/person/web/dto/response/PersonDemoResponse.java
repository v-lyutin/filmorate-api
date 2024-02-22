package com.filmorate.filmorateapi.media.person.web.dto.response;

import com.filmorate.filmorateapi.media.career.model.Career;
import java.util.Collection;

public record PersonDemoResponse(
        long id,
        String imageLink,
        String firstName,
        String lastName,
        Collection<Career> careers) {
}
