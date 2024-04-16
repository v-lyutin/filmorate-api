package com.filmorate.filmorateapi.media.staff.web.dto.response;

public record StaffResponse(
        long staffId,

        long movieId,

        long personId,

        String staffRole) {
}
