package com.filmorate.filmorateapi.user.web;

import com.filmorate.filmorateapi.user.usecase.UserProfileUtilUseCase;
import com.filmorate.filmorateapi.user.web.dto.UserProfilePageResponse;
import com.filmorate.filmorateapi.user.web.dto.UserProfileRegisterRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateImageLinkRequest;
import com.filmorate.filmorateapi.user.web.dto.UserProfileUpdateNicknameRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class UserProfileController {
    private final UserProfileUtilUseCase userProfileUtilUseCase;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest request) {
        userProfileUtilUseCase.registerUserProfile(request);
    }

    @GetMapping("/me")
    public UserProfilePageResponse getUserProfilePage() {
        return userProfileUtilUseCase.getUserProfile();
    }

    @PutMapping("/me/update/nickname")
    public void updateNickname(@Valid @RequestBody UserProfileUpdateNicknameRequest request) {
        userProfileUtilUseCase.updateNickname(request);
    }

    @PutMapping("/me/update/image")
    public void updateImageLink(@Valid @RequestBody UserProfileUpdateImageLinkRequest request) {
        userProfileUtilUseCase.updateImageLink(request);
    }
}
