package com.filmorate.filmorateapi.security.mapper.impl;

import com.filmorate.filmorateapi.security.mapper.UserAccountToUserAccountResponseMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.web.dto.response.UserAccountResponse;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserAccountResponseMapperImpl implements UserAccountToUserAccountResponseMapper {
    @Override
    public UserAccountResponse map(UserAccount userAccount) {
        return new UserAccountResponse(
                userAccount.getId(),
                userAccount.getEmail(),
                userAccount.getAuthorities()
        );
    }
}
