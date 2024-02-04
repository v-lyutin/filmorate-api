package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.UserProfileUseCase;
import com.filmorate.filmorateapi.user.web.dto.UserProfilePageResponse;
import com.filmorate.filmorateapi.user.web.dto.UserProfileCreationRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateImageLinkRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateNicknameRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileUseCase userProfileUtilUseCase;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileCreationRequest request) {
        userProfileUtilUseCase.registerUserProfile(request);
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfilePageResponse getUserProfilePage() {
        return userProfileUtilUseCase.getUserProfile();
    }

    @PutMapping(value = "/me/update/nickname", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateNickname(@Valid @RequestBody UserProfileUpdateNicknameRequest request) {
        userProfileUtilUseCase.updateNickname(request);
    }

    @PutMapping(value = "/me/update/image", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateImageLink(@Valid @RequestBody UserProfileUpdateImageLinkRequest request) {
        userProfileUtilUseCase.updateImageLink(request);
    }
}
