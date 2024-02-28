package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.user.PersonUserProfileUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class PersonUserProfileController {
    private final PersonUserProfileUseCase personUserProfileUseCase;

    @PostMapping(value = "/persons/{personId}/favorites")
    void addPersonToFavorites(@PathVariable(name = "personId") Long personId) {
        personUserProfileUseCase.addPersonToFavorites(personId);
    }

    @DeleteMapping(value = "/persons/{personId}/favorites")
    void removePersonFromFavorites(@PathVariable(name = "personId") Long personId) {
        personUserProfileUseCase.removePersonFromFavorites(personId);
    }

    @GetMapping(value = "/profiles/me/favoritePersons")
    List<PersonDemoResponse> getFavoritePersons() {
        return personUserProfileUseCase.getFavoritePersons();
    }
}
