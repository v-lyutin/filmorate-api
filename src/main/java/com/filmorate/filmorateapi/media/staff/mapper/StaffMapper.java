package com.filmorate.filmorateapi.media.staff.mapper;

import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffUpdateRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.MovieStaffPageResponse;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffCreationRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffResponse;
import org.springframework.data.domain.Page;

public interface StaffMapper {
    Staff map(Long movieId, StaffCreationRequest request);

    StaffResponse map(Staff staff);

    MovieStaffPageResponse map(Page<Staff> pageableStaff);

    Staff update(Staff staff, StaffUpdateRequest request);
}
