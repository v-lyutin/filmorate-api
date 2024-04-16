package com.filmorate.filmorateapi.media.staff.mapper.impl;

import com.filmorate.filmorateapi.media.staff.mapper.StaffRoleMapper;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffRoleRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffRoleResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffRoleMapperImpl implements StaffRoleMapper {
    @Override
    public StaffRole map(StaffRoleRequest request) {
        return StaffRole.builder()
                .position(request.position())
                .build();
    }

    @Override
    public StaffRoleResponse map(StaffRole staffRole) {
        return new StaffRoleResponse(
                staffRole.getId(),
                staffRole.getPosition());
    }

    @Override
    public List<StaffRoleResponse> map(List<StaffRole> staffRoles) {
        return staffRoles.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
