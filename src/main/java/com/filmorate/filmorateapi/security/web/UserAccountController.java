package com.filmorate.filmorateapi.security.web;

import com.filmorate.filmorateapi.security.usecase.UserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.AccessToken;
import com.filmorate.filmorateapi.security.web.dto.LoginRequest;
import com.filmorate.filmorateapi.security.web.dto.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserAccountController {
    private final UserAccountUseCase userAccountUseCase;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest request) {
        userAccountUseCase.register(request);
    }

    @PostMapping(
            value = "auth/jwt",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AccessToken getJwtToken(@Valid @RequestBody LoginRequest request) {
        return userAccountUseCase.authenticate(request);
    }

    @PutMapping(value = "/profiles/me/update/password", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePassword(@Valid @RequestBody PasswordRequest request) {
        userAccountUseCase.updatePassword(request);
    }
}
