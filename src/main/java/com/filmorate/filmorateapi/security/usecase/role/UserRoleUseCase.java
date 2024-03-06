package com.filmorate.filmorateapi.security.usecase.role;

import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.web.dto.request.AuthorityRequest;
import com.filmorate.filmorateapi.security.web.dto.response.UserAccountResponse;
import java.util.List;

public interface UserRoleUseCase {
    List<UserRole> getAllAuthorities();

    UserAccountResponse updateUserAccountAuthorities(Long userAccountId, AuthorityRequest request);

    UserAccountResponse removeUserAccountAuthorities(Long userAccountId, AuthorityRequest request);
}
