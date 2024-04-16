package com.filmorate.filmorateapi.media.staff.mapper;

import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffRoleRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffRoleResponse;
import java.util.List;

public interface StaffRoleMapper {
    StaffRole map(StaffRoleRequest request);

    StaffRoleResponse map(StaffRole staffRole);

    List<StaffRoleResponse> map(List<StaffRole> staffRoles);
}
