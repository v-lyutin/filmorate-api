package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.UserProfileRegisterUseCase;
import com.filmorate.filmorateapi.user.web.dto.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileRegisterUseCase userProfileRegisterUseCase;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest registerRequest) {
        userProfileRegisterUseCase.registerUserProfile(registerRequest);
    }
}
