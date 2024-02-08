package com.filmorate.filmorateapi.media.person.web.dto;

import java.util.Collection;

public record PersonsPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<PersonDemoResponse> persons) {
}
