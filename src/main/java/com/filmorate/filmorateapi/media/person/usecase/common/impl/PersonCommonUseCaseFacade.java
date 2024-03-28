package com.filmorate.filmorateapi.media.person.usecase.common.impl;

import com.filmorate.filmorateapi.media.person.mapper.*;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.common.PersonCommonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonCreationResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonCommonUseCaseFacade implements PersonCommonUseCase {
    private final PersonService personService;
    private final PersonUpdateMapper personUpdateMapper;
    private final PersonPageToPersonsPageResponseMapper personPageToPersonPageResponseMapper;
    private final PersonCreationRequestToPersonMapper personCreationRequestToPersonMapper;
    private final PersonToPersonResponseMapper personToPersonResponseMapper;
    private final PersonToPersonCreationResponseMapper personToPersonCreationResponseMapper;

    @Override
    public PersonsPageResponse findPersons(PersonFindRequest request) {
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<Person> pageablePersons = personService.findPersons(pageable);
        return personPageToPersonPageResponseMapper.map(pageablePersons);
    }

    @Override
    public PersonResponse getPersonById(Long personId) {
        Person person = personService.getPersonById(personId);
        return personToPersonResponseMapper.map(person);
    }

    @Override
    public PersonCreationResponse createPerson(PersonCreationRequest request) {
        Person person = personCreationRequestToPersonMapper.map(request);
        Person createdPerson = personService.createPerson(person);
        return personToPersonCreationResponseMapper.map(createdPerson);
    }

    @Override
    public void updatePersonById(Long personId, PersonUpdateRequest request) {
        Person person = personService.getPersonById(personId);
        personUpdateMapper.map(request, person);
        personService.updatePerson(person);
    }

    @Override
    public void deletePersonById(Long personId) {
        personService.deletePerson(personId);
    }
}
