package com.filmorate.filmorateapi.security.usecase.impl;

import com.filmorate.filmorateapi.security.mapper.RegisterRequestToUserAccountMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import com.filmorate.filmorateapi.security.usecase.RegisterUserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = mapper.map(registerRequest);
        userAccountService.createUserAccount(userAccount);
    }
}
