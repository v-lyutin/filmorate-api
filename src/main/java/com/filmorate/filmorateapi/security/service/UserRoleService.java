package com.filmorate.filmorateapi.security.service;

import com.filmorate.filmorateapi.security.model.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole getUserRole();

    UserRole getUserRoleByAuthority(String authority);

    List<UserRole> getAllAuthorities();
}
