package com.filmorate.filmorateapi.media.person.web.dto.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.Collection;

public record PersonAddCareerRequest(
        @NotEmpty
        Collection<String> careers) {
}
