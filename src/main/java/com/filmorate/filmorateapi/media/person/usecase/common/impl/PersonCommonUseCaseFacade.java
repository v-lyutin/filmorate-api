package com.filmorate.filmorateapi.media.person.usecase.common.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonCreationRequestToPersonMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonPageToPersonsPageResponseMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonUpdateMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.common.PersonCommonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
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

    @Override
    public PersonsPageResponse findPersons(PersonFindRequest request) {
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        Page<Person> pageablePersons = personService.findPersons(pageable);
        return personPageToPersonPageResponseMapper.map(pageablePersons);
    }

    @Override
    public Person getPersonById(Long personId) {
        return personService.getPersonById(personId);
    }

    @Override
    public void createPerson(PersonCreationRequest request) {
        Person person = personCreationRequestToPersonMapper.map(request);
        personService.createPerson(person);
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
