package com.filmorate.filmorateapi.security.service.impl;

import com.filmorate.filmorateapi.security.exception.UserAccountServiceException;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.repository.UserAccountRepository;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;

    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean isUsernameExists = userAccountRepository.existsByEmail(userAccount.getEmail());

        if (isUsernameExists) {
            throw new UserAccountServiceException("Account with this username already exists");
        }

        userAccountRepository.save(userAccount);
    }
}
