package com.filmorate.filmorateapi.security.api.service.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService userAccountService;

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(Authentication::getName)
                .flatMap(this::extractCurrentUserApiModel);
    }

    private Optional<CurrentUserApiModel> extractCurrentUserApiModel(String email) {
        return userAccountService
                .findUserByEmail(email)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
