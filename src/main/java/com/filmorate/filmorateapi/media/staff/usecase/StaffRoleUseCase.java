package com.filmorate.filmorateapi.media.staff.usecase;

import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffRoleRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffRoleResponse;
import java.util.List;

public interface StaffRoleUseCase {
    StaffRoleResponse createStaffRole(StaffRoleRequest staffRoleRequest);

    StaffRoleResponse updateStaffRole(Long staffRoleId, StaffRoleRequest staffRoleRequest);

    List<StaffRoleResponse> getAllStaffRoles();

    void removeStaffRoleById(Long staffRoleId);
}
