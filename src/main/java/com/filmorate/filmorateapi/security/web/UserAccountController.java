package com.filmorate.filmorateapi.security.web;

import com.filmorate.filmorateapi.security.usecase.common.UserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.response.AccessToken;
import com.filmorate.filmorateapi.security.web.dto.request.LoginRequest;
import com.filmorate.filmorateapi.security.web.dto.request.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.request.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class UserAccountController {
    private final UserAccountUseCase userAccountUseCase;

    @PostMapping(value = "register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest request) {
        userAccountUseCase.register(request);
    }

    @PostMapping(value = "auth/jwt")
    public AccessToken getJwtToken(@Valid @RequestBody LoginRequest request) {
        return userAccountUseCase.authenticate(request);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping(value = "/profiles/me/update/password")
    public void updatePassword(@Valid @RequestBody PasswordRequest request) {
        userAccountUseCase.updatePassword(request);
    }
}
