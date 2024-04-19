package com.filmorate.filmorateapi.media.person.web.dto.response;

import java.util.Collection;

public record PersonsPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<PersonPreviewResponse> persons) {
}
