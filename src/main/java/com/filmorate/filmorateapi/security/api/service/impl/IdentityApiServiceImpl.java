package com.filmorate.filmorateapi.security.api.service.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
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
    public Optional<CurrentUserAccountApiModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(Authentication::getName)
                .flatMap(this::extractCurrentUserAccountApiModel);
    }


    private Optional<CurrentUserAccountApiModel> extractCurrentUserAccountApiModel(String email) {
        return userAccountService
                .findUserByEmail(email)
                .map(userAccount -> new CurrentUserAccountApiModel(userAccount.getId()));
    }
}
