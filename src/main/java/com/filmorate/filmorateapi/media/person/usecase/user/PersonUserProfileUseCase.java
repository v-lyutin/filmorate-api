package com.filmorate.filmorateapi.media.person.usecase.user;

public interface PersonUserProfileUseCase {
    void addPersonToFavorites(Long personId);

    void removePersonFromFavorites(Long personId);
}
