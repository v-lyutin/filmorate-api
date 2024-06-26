package com.filmorate.filmorateapi.media.person.web.dto.response;

import java.util.Set;

public record PersonPreviewResponse(
        long id,

        String imageLink,

        String name,

        String enName,

        Set<String> careers) {
}
