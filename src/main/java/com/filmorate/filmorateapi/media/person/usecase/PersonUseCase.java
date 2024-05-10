package com.filmorate.filmorateapi.media.person.usecase;

import com.filmorate.filmorateapi.media.person.web.dto.filter.PersonFilter;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PersonUseCase {

    PersonResponse createPerson(PersonCreationRequest request);

    PersonResponse updatePerson(Long personId, PersonUpdateRequest request);

    PersonResponse getPersonById(Long personId);

    PersonsPageResponse getPersonsWithFilters(PersonFilter personFilter, @Valid PersonFindRequest request);

    void removePersonById(Long personId);
}
