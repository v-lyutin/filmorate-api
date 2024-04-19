package com.filmorate.filmorateapi.media.staff.usecase.impl;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.staff.mapper.StaffMapper;
import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.service.StaffRoleService;
import com.filmorate.filmorateapi.media.staff.service.StaffService;
import com.filmorate.filmorateapi.media.staff.usecase.StaffUseCase;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffUpdateRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.MovieStaffPageResponse;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffCreationRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StaffUseCaseFacade implements StaffUseCase {
    private final StaffService staffService;
    private final MovieService movieService;
    private final StaffRoleService staffRoleService;
    private final StaffMapper staffMapper;

    @Override
    public StaffResponse createStaff(Long movieId, StaffCreationRequest request) {
        Staff staff = staffMapper.map(movieId, request);
        Staff createdStaff = staffService.createStaff(staff);
        return staffMapper.map(createdStaff);
    }

    @Override
    public StaffResponse updateStaff(Long staffId, StaffUpdateRequest request) {
        Staff staff = staffService.getStaffById(staffId);
        Staff updatedStaff = staffMapper.update(staff, request);
        return staffMapper.map(staffService.updateStaff(updatedStaff));
    }

    @Override
    public StaffResponse getStaffById(Long staffId) {
        Staff staff = staffService.getStaffById(staffId);
        return staffMapper.map(staff);
    }

    @Override
    public MovieStaffPageResponse getAllStaffByMovie(Long movieId, PageFindRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<Staff> pageableStaff = staffService.getAllStaffByMovie(pageable, movie);
        return staffMapper.map(pageableStaff);
    }

    @Override
    public MovieStaffPageResponse getAllStaffByMovieAndStaffRole(Long movieId, String staffRole, PageFindRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        StaffRole position = staffRoleService.getStaffRoleByPosition(staffRole);
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<Staff> pageableStaff = staffService.getAllStaffByMovieAndStaffRole(pageable, movie, position);
        return staffMapper.map(pageableStaff);
    }

    @Override
    public void removeStaffById(Long staffId) {
        staffService.removeStaffById(staffId);
    }

    @Override
    public void removeAllStaffByMovie(Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        staffService.removeAllStaffByMovie(movie);
    }
}
