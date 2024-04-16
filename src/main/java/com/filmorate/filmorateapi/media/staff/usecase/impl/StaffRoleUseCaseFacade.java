package com.filmorate.filmorateapi.media.staff.usecase.impl;

import com.filmorate.filmorateapi.media.staff.mapper.StaffRoleMapper;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.service.StaffRoleService;
import com.filmorate.filmorateapi.media.staff.usecase.StaffRoleUseCase;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffRoleRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffRoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StaffRoleUseCaseFacade implements StaffRoleUseCase {
    private final StaffRoleService staffRoleService;
    private final StaffRoleMapper staffRoleMapper;

    @Override
    public StaffRoleResponse createStaffRole(StaffRoleRequest request) {
        StaffRole staffRole = staffRoleMapper.map(request);
        return staffRoleMapper.map(staffRoleService.createStaffRole(staffRole));
    }

    @Override
    public StaffRoleResponse updateStaffRole(Long staffRoleId, StaffRoleRequest staffRoleRequest) {
        StaffRole staffRole = staffRoleService.getStaffRoleById(staffRoleId);
        staffRole.setPosition(staffRoleRequest.position());
        return staffRoleMapper.map(staffRoleService.updateStaffRole(staffRole));
    }

    @Override
    public List<StaffRoleResponse> getAllStaffRoles() {
        return staffRoleMapper.map(staffRoleService.getAllStaffRoles());
    }

    @Override
    public void removeStaffRoleById(Long staffRoleId) {
        staffRoleService.removeStaffRoleById(staffRoleId);
    }
}
