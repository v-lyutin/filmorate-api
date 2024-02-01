package com.filmorate.filmorateapi.security.web;

import com.filmorate.filmorateapi.security.usecase.UserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.PasswordRequest;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserAccountController {
    private final UserAccountUseCase userAccountUseCase;

    @PostMapping(value = "/register", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest request) {
        userAccountUseCase.register(request);
    }

    @PutMapping(value = "/profiles/me/update/password", consumes = "application/json")
    public void updatePassword(@Valid @RequestBody PasswordRequest request) {
        userAccountUseCase.updatePassword(request);
    }
}
