package com.filmorate.filmorateapi.media.staff.usecase;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffUpdateRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.MovieStaffPageResponse;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffCreationRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface StaffUseCase {
    StaffResponse createStaff(Long movieId, StaffCreationRequest request);

    StaffResponse updateStaff(Long staffId, StaffUpdateRequest request);

    StaffResponse getStaffById(Long staffId);

    MovieStaffPageResponse getAllStaffByMovie(Long movieId, @Valid PageFindRequest request);

    MovieStaffPageResponse getAllStaffByMovieAndStaffRole(Long movieId, String staffRole, @Valid PageFindRequest request);

    void removeStaffById(Long staffId);

    void removeAllStaffByMovie(Long movieId);
}
