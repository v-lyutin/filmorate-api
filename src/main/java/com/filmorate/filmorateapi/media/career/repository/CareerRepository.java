package com.filmorate.filmorateapi.media.career.repository;

import com.filmorate.filmorateapi.media.career.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    boolean existsByName(String name);

    Optional<Career> findByName(String name);
}
