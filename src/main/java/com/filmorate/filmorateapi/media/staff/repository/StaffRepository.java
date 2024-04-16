package com.filmorate.filmorateapi.media.staff.repository;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Page<Staff> findAllByMovie(Pageable pageable, Movie movie);

    Page<Staff> findAllByMovieAndStaffRole(Pageable pageable, Movie movie, StaffRole staffRole);

    void deleteAllByMovie(Movie movie);
}
