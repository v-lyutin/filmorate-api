package com.filmorate.filmorateapi.media.person.web.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.Collection;

public record PersonAddCareersRequest(
        @NotEmpty
        Collection<String> careers) {
}
