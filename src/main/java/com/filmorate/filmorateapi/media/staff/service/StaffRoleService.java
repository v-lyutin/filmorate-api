package com.filmorate.filmorateapi.media.staff.service;

import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import java.util.List;

public interface StaffRoleService {
    StaffRole createStaffRole(StaffRole staffRole);

    StaffRole updateStaffRole(StaffRole staffRole);

    StaffRole getStaffRoleById(Long staffRoleId);

    StaffRole getStaffRoleByPosition(String position);

    List<StaffRole> getAllStaffRoles();

    void removeStaffRoleById(Long staffRoleId);
}
