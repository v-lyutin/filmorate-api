package com.filmorate.filmorateapi.media.staff.service.impl;

import com.filmorate.filmorateapi.media.staff.exception.StaffRoleServiceException;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.repository.StaffRoleRepository;
import com.filmorate.filmorateapi.media.staff.service.StaffRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffRoleServiceImpl implements StaffRoleService {
    private final StaffRoleRepository staffRoleRepository;

    @Override
    public StaffRole createStaffRole(StaffRole staffRole) {
        if (staffRoleRepository.existsByPositionContainingIgnoreCase(staffRole.getPosition())) {
            throw new StaffRoleServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Position with name '%s' already exists", staffRole.getPosition()));
        }
        return staffRoleRepository.save(staffRole);
    }

    @Override
    public StaffRole updateStaffRole(StaffRole staffRole) {
        if (staffRoleRepository.existsByPositionContainingIgnoreCase(staffRole.getPosition())) {
            throw new StaffRoleServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Position with name '%s' already exists", staffRole.getPosition()));
        }
        return staffRoleRepository.save(staffRole);
    }

    @Override
    public StaffRole getStaffRoleById(Long staffRoleId) {
        return staffRoleRepository.findById(staffRoleId)
                .orElseThrow(() -> new StaffRoleServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Position with ID '%d' already exists", staffRoleId)));
    }

    @Override
    public StaffRole getStaffRoleByPosition(String position) {
        return staffRoleRepository.findByPositionContainingIgnoreCase(position)
                .orElseThrow(() -> new StaffRoleServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Position with name '%s' not found", position)));
    }

    @Override
    public List<StaffRole> getAllStaffRoles() {
        return staffRoleRepository.findAll();
    }

    @Override
    public void removeStaffRoleById(Long staffRoleId) {
        staffRoleRepository.deleteById(staffRoleId);
    }
}
