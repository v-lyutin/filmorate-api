package com.filmorate.filmorateapi.media.person.web.dto.response;

import java.util.Set;

public record PersonDemoResponse(
        long id,

        String imageLink,

        String name,

        Set<String> careers) {
}
