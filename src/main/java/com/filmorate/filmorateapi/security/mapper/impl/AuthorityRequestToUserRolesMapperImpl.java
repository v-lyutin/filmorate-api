package com.filmorate.filmorateapi.security.mapper.impl;

import com.filmorate.filmorateapi.security.mapper.AuthorityRequestToUserRoleMapper;
import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorityRequestToUserRolesMapperImpl implements AuthorityRequestToUserRoleMapper {
    private final UserRoleService userRoleService;

    @Override
    public Set<UserRole> map(Set<String> source) {
        return source.stream()
                .map(userRoleService::getUserRoleByAuthority)
                .collect(Collectors.toSet());
    }
}
