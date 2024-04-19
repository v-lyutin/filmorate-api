package com.filmorate.filmorateapi.media.person.usecase.user;

import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import java.util.List;

public interface PersonUserProfileUseCase {
    void addPersonToFavorites(Long personId);

    void removePersonFromFavorites(Long personId);

    List<PersonPreviewResponse> getFavoritePersons();
}
