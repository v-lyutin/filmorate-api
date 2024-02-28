package com.filmorate.filmorateapi.security.usecase.admin.impl;

import com.filmorate.filmorateapi.security.mapper.AuthorityRequestToUserRoleMapper;
import com.filmorate.filmorateapi.security.mapper.UserAccountToUserAccountResponseMapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.service.UserAccountService;
import com.filmorate.filmorateapi.security.service.UserRoleService;
import com.filmorate.filmorateapi.security.usecase.admin.UserAccountAdminUseCase;
import com.filmorate.filmorateapi.security.web.dto.request.AuthorityRequest;
import com.filmorate.filmorateapi.security.web.dto.response.UserAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserAccountAdminUseCaseFacade implements UserAccountAdminUseCase {
    private final UserAccountService userAccountService;
    private final UserRoleService userRoleService;
    private final UserAccountToUserAccountResponseMapper userAccountToUserAccountResponseMapper;
    private final AuthorityRequestToUserRoleMapper authorityRequestToUserRoleMapper;

    @Override
    public List<UserRole> getAllAuthorities() {
        return userRoleService.getAllAuthorities();
    }

    @Override
    public UserAccountResponse updateUserAccountAuthorities(Long userAccountId, AuthorityRequest request) {
        UserAccount userAccount = userAccountService.getUserAccountById(userAccountId);
        Set<UserRole> authorities = authorityRequestToUserRoleMapper.map(request.authorities());
        userAccount.getAuthorities().addAll(authorities);
        UserAccount updatedUserAccount = userAccountService.updateUserAccount(userAccount);
        return userAccountToUserAccountResponseMapper.map(updatedUserAccount);
    }

    @Override
    public UserAccountResponse removeUserAccountAuthorities(Long userAccountId, AuthorityRequest request) {
        UserAccount userAccount = userAccountService.getUserAccountById(userAccountId);
        Set<UserRole> authorities = authorityRequestToUserRoleMapper.map(request.authorities());
        userAccount.getAuthorities().removeAll(authorities);
        UserAccount updatedUserAccount = userAccountService.updateUserAccount(userAccount);
        return userAccountToUserAccountResponseMapper.map(updatedUserAccount);
    }
}
