package com.filmorate.filmorateapi.user.usecase;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.user.web.dto.*;
import java.util.Set;

public interface UserProfileUseCase {
    void registerUserProfile(UserProfileCreationRequest request);

    UserProfilePageResponse getUserProfile();

    void updateNickname(UserProfileUpdateNicknameRequest request);

    void updateImageLink(UserProfileUpdateImageLinkRequest request);

    Set<Person> getFavoritePersons();
}
