package com.filmorate.filmorateapi.security.service;

import com.filmorate.filmorateapi.security.model.UserRole;
import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
