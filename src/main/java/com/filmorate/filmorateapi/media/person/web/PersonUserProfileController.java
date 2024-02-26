package com.filmorate.filmorateapi.media.person.web;

import com.filmorate.filmorateapi.media.person.usecase.user.PersonUserProfileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/persons")
public class PersonUserProfileController {
    private final PersonUserProfileUseCase personUserProfileUseCase;

    @PostMapping(value = "/{personId}/favorites")
    void addPersonToFavorites(@PathVariable(name = "personId") Long personId) {
        personUserProfileUseCase.addPersonToFavorites(personId);
    }

    @DeleteMapping(value = "/{personId}/favorites")
    void removePersonFromFavorites(@PathVariable(name = "personId") Long personId) {
        personUserProfileUseCase.removePersonFromFavorites(personId);
    }
}
