package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.user.usecase.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.UserProfilePageResponse;
import com.filmorate.filmorateapi.user.web.dto.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateImageLinkRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateNicknameRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileUseCase userProfileUtilUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerUserProfile(@Valid @RequestBody UserProfileCreationRequest request) {
        userProfileUtilUseCase.registerUserProfile(request);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfilePageResponse getUserProfilePage() {
        return userProfileUtilUseCase.getUserProfile();
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping(value = "/me/update/nickname", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateNickname(@Valid @RequestBody UserProfileUpdateNicknameRequest request) {
        userProfileUtilUseCase.updateNickname(request);
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    @PutMapping(value = "/me/update/image", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateImageLink(@Valid @RequestBody UserProfileUpdateImageLinkRequest request) {
        userProfileUtilUseCase.updateImageLink(request);
    }
}
