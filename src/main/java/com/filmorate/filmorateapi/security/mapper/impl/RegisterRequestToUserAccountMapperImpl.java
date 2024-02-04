package com.filmorate.filmorateapi.security.mapper.impl;

import com.filmorate.filmorateapi.security.exception.UserRoleServiceException;
import com.filmorate.filmorateapi.security.mapper.RegisterRequestToUserAccountMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.service.UserRoleService;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Locale;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAccount map(RegisterRequest registerRequest) {
        UserRole userRole = userRoleService.findUserRole()
                .orElseThrow(() -> new UserRoleServiceException("Роль пользователя не найдена"));

        return UserAccount.builder()
                .email(registerRequest.email().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(registerRequest.password()))
                .authorities(Set.of(userRole))
                .build();
    }
}
