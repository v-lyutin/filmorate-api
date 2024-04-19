package com.filmorate.filmorateapi.media.staff.repository;

import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StaffRoleRepository extends JpaRepository<StaffRole, Long> {
    boolean existsByPositionContainingIgnoreCase(String position);

    Optional<StaffRole> findByPositionContainingIgnoreCase(String position);
}
