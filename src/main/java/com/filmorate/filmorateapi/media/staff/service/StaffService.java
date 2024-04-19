package com.filmorate.filmorateapi.media.staff.service;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Staff createStaff(Staff staff);

    Staff updateStaff(Staff staff);

    Staff getStaffById(Long staffId);

    Page<Staff> getAllStaffByMovie(Pageable pageable, Movie movie);

    Page<Staff> getAllStaffByMovieAndStaffRole(Pageable pageable, Movie movie, StaffRole staffRole);

    void removeStaffById(Long staffId);

    void removeAllStaffByMovie(Movie movie);
}
