package com.filmorate.filmorateapi.security.mapper.impl;

import com.filmorate.filmorateapi.security.mapper.UserAccountToUserMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getEmail(),
                userAccount.getPassword(),
                userAccount.getAuthorities()
        );
    }
}
