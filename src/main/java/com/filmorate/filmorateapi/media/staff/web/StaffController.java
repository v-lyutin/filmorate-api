package com.filmorate.filmorateapi.media.staff.web;

import com.filmorate.filmorateapi.common.web.dto.PageFindRequest;
import com.filmorate.filmorateapi.media.staff.usecase.StaffUseCase;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffCreationRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffUpdateRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.MovieStaffPageResponse;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "api/v1/movies")
public class StaffController {
    private final StaffUseCase staffUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "{movieId:\\d+}/staff")
    public StaffResponse addStaff(@PathVariable(name = "movieId") Long movieId,
                                  @Valid @RequestBody StaffCreationRequest request) {
        return staffUseCase.createStaff(movieId, request);
    }

    @PatchMapping(value = "staff/{staffId:\\d+}")
    public StaffResponse updateStaffById(@PathVariable(name = "staffId") Long staffId,
                                         @Valid @RequestBody StaffUpdateRequest request) {
        return staffUseCase.updateStaff(staffId, request);
    }

    @GetMapping(value = "staff/{staffId:\\d+}")
    public StaffResponse getStaffById(@PathVariable(name = "staffId") Long staffId) {
        return staffUseCase.getStaffById(staffId);
    }

    @GetMapping(value = "{movieId:\\d+}/staff")
    public MovieStaffPageResponse getAllStaffByMovie(@PathVariable(name = "movieId") Long movieId,
                                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "limit", defaultValue = "10") int limit,
                                                     @RequestParam(name = "staffRole", required = false) String staffRole) {
        PageFindRequest pageFindRequest = new PageFindRequest(page, limit);
        if (staffRole == null) {
            return staffUseCase.getAllStaffByMovie(movieId, pageFindRequest);
        }
        return staffUseCase.getAllStaffByMovieAndStaffRole(movieId, staffRole, pageFindRequest);
    }

    @DeleteMapping(value = "staff/{staffId:\\d+}")
    public void removeStaffById(@PathVariable(name = "staffId") Long staffId) {
        staffUseCase.removeStaffById(staffId);
    }

    @DeleteMapping(value = "{movieId:\\d+}/staff")
    public void removeAllStaffByMovie(@PathVariable(name = "movieId") Long movieId) {
        staffUseCase.removeAllStaffByMovie(movieId);
    }
}
