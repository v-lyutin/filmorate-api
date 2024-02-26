package com.filmorate.filmorateapi.media.person.usecase.common;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.*;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonCommonUseCase {
    PersonsPageResponse findPersons(@Valid PersonFindRequest request);

    PersonResponse getPersonById(Long personId);

    void createPerson(PersonCreationRequest request);

    void updatePersonById(Long personId, PersonUpdateRequest request);

    void deletePersonById(Long personId);
}
