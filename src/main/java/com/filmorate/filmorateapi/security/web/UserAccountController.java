package com.filmorate.filmorateapi.security.web;

import com.filmorate.filmorateapi.security.usecase.RegisterUserAccountUseCase;
import com.filmorate.filmorateapi.security.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class UserAccountController {
    private final RegisterUserAccountUseCase registerUserAccountUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        registerUserAccountUseCase.register(registerRequest);
    }
}
