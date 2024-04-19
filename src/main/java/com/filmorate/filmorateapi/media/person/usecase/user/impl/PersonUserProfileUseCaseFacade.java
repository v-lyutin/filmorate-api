package com.filmorate.filmorateapi.media.person.usecase.user.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.user.PersonUserProfileUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonUserProfileUseCaseFacade implements PersonUserProfileUseCase {
    private final PersonService personService;
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final PersonMapper personMapper;

    @Override
    public void addPersonToFavorites(Long personId) {
        Person person = personService.getPersonById(personId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        userProfile.getFavoritePersons().add(person);
        currentUserProfileApiService.updateUserProfile(userProfile);
    }

    @Override
    public void removePersonFromFavorites(Long personId) {
        Person person = personService.getPersonById(personId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        userProfile.getFavoritePersons().removeIf(currentPerson -> currentPerson.equals(person));
        currentUserProfileApiService.updateUserProfile(userProfile);
    }

    @Override
    public List<PersonPreviewResponse> getFavoritePersons() {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        return userProfile.getFavoritePersons().stream()
                .map(personMapper::toPersonDemoResponse)
                .collect(Collectors.toList());
    }
}
