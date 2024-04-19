package com.filmorate.filmorateapi.media.staff.web;

import com.filmorate.filmorateapi.media.staff.usecase.StaffRoleUseCase;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffRoleRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffRoleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/staff/roles")
public class StaffRoleController {
    private final StaffRoleUseCase staffRoleUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StaffRoleResponse addStaffRole(@Valid @RequestBody StaffRoleRequest request) {
        return staffRoleUseCase.createStaffRole(request);
    }

    @PutMapping(value = "/{staffRoleId}")
    public StaffRoleResponse updateStaffRole(@PathVariable(name = "staffRoleId") Long staffRoleId,
                                             @Valid @RequestBody StaffRoleRequest request) {
        return staffRoleUseCase.updateStaffRole(staffRoleId, request);
    }

    @GetMapping
    public List<StaffRoleResponse> getAllStaffRoles() {
        return staffRoleUseCase.getAllStaffRoles();
    }

    @DeleteMapping(value = "/{staffRoleId}")
    public void removeStaffRole(@PathVariable(name = "staffRoleId") Long staffRoleId) {
        staffRoleUseCase.removeStaffRoleById(staffRoleId);
    }
}
