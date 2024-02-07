package com.filmorate.filmorateapi.media.person.web.dto;

import com.filmorate.filmorateapi.media.person.model.Person;
import java.util.Collection;

public record PersonPageResponse(
        long totalPages,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<Person> persons) {
}
