package com.filmorate.filmorateapi.media.compilation.web.dto.request;

import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Set;

public record CompilationUpdateRequest(
    @Size(max = 32, message = "The size of the 'title' field must not exceed 32 characters")
    JsonNullable<String> title,

    @Size(max = 1000, message = "The size of the 'description' field must not exceed 1000 characters")
    JsonNullable<String> description,

    JsonNullable<Set<String>> genres) {
}
