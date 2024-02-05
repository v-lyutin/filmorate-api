package com.filmorate.filmorateapi.media.career.repository;

import com.filmorate.filmorateapi.media.career.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
    boolean existsByName(String name);
}
