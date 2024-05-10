package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.common.impl.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.request.UserProfileUpdateRequest;
import com.filmorate.filmorateapi.user.web.dto.response.CurrentUserProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/profiles")
public class UserProfileController {
    private final UserProfileUseCase userProfileUseCase;

    @PostMapping(value = "create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public CurrentUserProfileResponse registerUserProfile(@Valid @RequestBody UserProfileCreationRequest request) {
        return userProfileUseCase.registerUserProfile(request);
    }

    @GetMapping(value = "myProfile")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public CurrentUserProfileResponse getUserCurrentProfile() {
        return userProfileUseCase.getCurrentUserProfile();
    }

    @PatchMapping("myProfile")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public CurrentUserProfileResponse updateUserProfile(@Valid @RequestBody UserProfileUpdateRequest request) {
        return userProfileUseCase.updateUserProfile(request);
    }

    @GetMapping(value = "{userProfileId:\\d+}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<Object> getUserProfileById(@PathVariable(name = "userProfileId") Long userProfileId) {
        return userProfileUseCase.getUserProfileById(userProfileId);
    }
}
