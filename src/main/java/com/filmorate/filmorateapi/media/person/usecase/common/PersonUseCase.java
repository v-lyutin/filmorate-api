package com.filmorate.filmorateapi.media.person.usecase.common;

import com.filmorate.filmorateapi.media.person.web.dto.request.*;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {

    PersonResponse createPerson(PersonCreationRequest request);

    PersonResponse updatePerson(Long personId, PersonUpdateRequest request);

    PersonResponse getPersonById(Long personId);

    PersonsPageResponse getAllPersons(@Valid PersonFindRequest request);

    void removePersonById(Long personId);
}
