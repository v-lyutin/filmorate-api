package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileUseCase userProfileUseCase;

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void registerUserProfile(@Valid @RequestBody UserProfileCreationRequest request) {
        userProfileUseCase.registerUserProfile(request);
    }

    @GetMapping(value = "/me")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public UserProfileResponse getUserProfilePage() {
        return userProfileUseCase.getUserProfile();
    }

    @PatchMapping("/me")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public UserProfileResponse updateUserProfile(@Valid @RequestBody UserProfileUpdateRequest request) {
        return userProfileUseCase.updateUserProfile(request);
    }
}
