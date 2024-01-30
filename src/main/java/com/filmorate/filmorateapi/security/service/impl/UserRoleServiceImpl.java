package com.filmorate.filmorateapi.security.service.impl;

import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.repository.UserRoleRepository;
import com.filmorate.filmorateapi.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }
}
