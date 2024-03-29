package com.filmorate.filmorateapi.security.web;

import com.filmorate.filmorateapi.security.model.UserRole;
import com.filmorate.filmorateapi.security.usecase.role.UserRoleUseCase;
import com.filmorate.filmorateapi.security.web.dto.request.AuthorityRequest;
import com.filmorate.filmorateapi.security.web.dto.response.UserAccountResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserRoleController {
    private final UserRoleUseCase userRoleUseCase;

    @GetMapping(value = "authorities")
    public List<UserRole> getAllAuthorities() {
        return userRoleUseCase.getAllAuthorities();
    }

    @PutMapping(value = "profiles/{userAccountId:\\d+}/authorities")
    public UserAccountResponse updateUserAccountAuthorities(
            @PathVariable(name = "userAccountId") Long userAccountId,
            @Valid @RequestBody AuthorityRequest request) {
        return userRoleUseCase.updateUserAccountAuthorities(userAccountId, request);
    }

    @DeleteMapping(value = "profiles/{userAccountId:\\d+}/authorities")
    public UserAccountResponse removeUserAccountAuthorities(
            @PathVariable(name = "userAccountId") Long userAccountId,
            @Valid @RequestBody AuthorityRequest request) {
        return userRoleUseCase.removeUserAccountAuthorities(userAccountId, request);
    }
}
