package com.filmorate.filmorateapi.media.staff.web.dto.request;

import org.openapitools.jackson.nullable.JsonNullable;

public record StaffUpdateRequest(
        JsonNullable<String> staffRole,

        JsonNullable<Long> personId) {
}
