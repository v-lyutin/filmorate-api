package com.filmorate.filmorateapi.security.usecase.impl;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import com.filmorate.filmorateapi.security.api.service.IdentityApiService;
import com.filmorate.filmorateapi.security.exception.IdentityApiServiceException;
import com.filmorate.filmorateapi.security.mapper.RegisterRequestToUserAccountMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import com.filmorate.filmorateapi.security.usecase.UserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAccountUseCaseFacade implements UserAccountUseCase {
    private final UserAccountService userAccountService;
    private final IdentityApiService identityApiService;
    private final RegisterRequestToUserAccountMapper mapper;

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = mapper.map(registerRequest);
        userAccountService.createUserAccount(userAccount);
    }

    @Override
    public void updatePassword(PasswordRequest passwordRequest) {
        CurrentUserAccountApiModel currentUserAccountApiModel = identityApiService.currentUserAccount()
                        .orElseThrow(() -> new IdentityApiServiceException(
                                "Для данного действия пользователь должен быть авторизован в системе"
                        ));
        userAccountService.updatePassword(
                currentUserAccountApiModel.userAccountId(),
                passwordRequest.newPassword(),
                passwordRequest.oldPassword());
    }
}
