package com.filmorate.filmorateapi.security.service.impl;

import com.filmorate.filmorateapi.security.exception.UserAccountServiceException;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.repository.UserAccountRepository;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean isUsernameExists = userAccountRepository.existsByEmail(userAccount.getEmail());
        if (isUsernameExists) {
            throw new UserAccountServiceException(
                    HttpStatus.BAD_REQUEST,
                    "The account with the specified email address is already in use"
            );
        }
        userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByEmail(String email) {
        return userAccountRepository.findByEmail(email);
    }

    @Override
    public void updatePassword(Long userAccountId, String newPassword, String oldPassword) {
        UserAccount userAccount = userAccountRepository.findById(userAccountId)
                .orElseThrow(() -> new UserAccountServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("User account with ID = %d not found", userAccountId)
                ));
        if (!passwordEncoder.matches(oldPassword, userAccount.getPassword())) {
            throw new UserAccountServiceException(
                    HttpStatus.BAD_REQUEST,
                    "The old passwords don't match");
        }
        userAccount.setPassword(passwordEncoder.encode(newPassword));
        userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount getUserAccountById(Long userAccountId) {
        return userAccountRepository.findById(userAccountId)
                .orElseThrow(() -> new UserAccountServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("User account with ID = %d not found", userAccountId)
                ));
    }
}
