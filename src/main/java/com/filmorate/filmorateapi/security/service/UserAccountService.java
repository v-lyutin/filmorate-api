package com.filmorate.filmorateapi.security.service;

import com.filmorate.filmorateapi.security.model.UserAccount;
import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);

    Optional<UserAccount> findUserByEmail(String email);
}
