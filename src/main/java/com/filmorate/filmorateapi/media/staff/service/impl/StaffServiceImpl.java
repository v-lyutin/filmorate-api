package com.filmorate.filmorateapi.media.staff.service.impl;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.staff.exception.StaffServiceException;
import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.repository.StaffRepository;
import com.filmorate.filmorateapi.media.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(Long staffId) {
        return staffRepository.findById(staffId)
                .orElseThrow(() -> new StaffServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Staff with ID = '%d' not found", staffId)));
    }

    @Override
    public Page<Staff> getAllStaffByMovie(Pageable pageable, Movie movie) {
        return staffRepository.findAllByMovie(pageable, movie);
    }

    @Override
    public Page<Staff> getAllStaffByMovieAndStaffRole(Pageable pageable, Movie movie, StaffRole staffRole) {
        return staffRepository.findAllByMovieAndStaffRole(pageable, movie, staffRole);
    }

    @Override
    public void removeStaffById(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public void removeAllStaffByMovie(Movie movie) {
        staffRepository.deleteAllByMovie(movie);
    }
}
