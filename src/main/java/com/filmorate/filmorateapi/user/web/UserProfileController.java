package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import com.filmorate.filmorateapi.user.web.dto.response.UserProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public CurrentUserProfileResponse getUserProfilePage() {
        return userProfileUseCase.getUserProfile();
    }

    @PatchMapping("/me")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public CurrentUserProfileResponse updateUserProfile(@Valid @RequestBody UserProfileUpdateRequest request) {
        return userProfileUseCase.updateUserProfile(request);
    }

    @GetMapping(value = "/{userProfileId}")
    public ResponseEntity<Object> getUserProfileById(@PathVariable(name = "userProfileId") Long userProfileId) {
        return userProfileUseCase.getUserProfileById(userProfileId);
    }
}
