package com.filmorate.filmorateapi.media.staff.web.dto.response;

import java.util.List;

public record MovieStaffPageResponse(
        long totalPages,

        boolean isFirstPage,

        boolean isLastPage,

        long totalStaffMembers,

        List<StaffResponse> staff) {
}
