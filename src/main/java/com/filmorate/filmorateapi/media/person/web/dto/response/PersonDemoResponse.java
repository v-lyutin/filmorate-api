package com.filmorate.filmorateapi.media.person.web.dto.response;

import java.util.List;

public record PersonDemoResponse(
        long id,

        String imageLink,

        String name,

        List<String> careers) {
}
