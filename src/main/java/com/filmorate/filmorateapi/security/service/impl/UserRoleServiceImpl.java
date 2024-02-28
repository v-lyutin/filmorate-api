package com.filmorate.filmorateapi.security.service.impl;

import com.filmorate.filmorateapi.security.exception.UserRoleServiceException;
import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.repository.UserRoleRepository;
import com.filmorate.filmorateapi.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRole getUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER")
                .orElseThrow(() -> new UserRoleServiceException(
                        HttpStatus.NOT_FOUND,
                        "The user role was not found"
                ));
    }

    @Override
    public UserRole getUserRoleByAuthority(String authority) {
        return userRoleRepository.findByAuthority(authority)
                .orElseThrow(() -> new UserRoleServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("The role with authority '%s' not found", authority)
                ));
    }

    @Override
    public List<UserRole> getAllAuthorities() {
        return userRoleRepository.findAll();
    }
}
