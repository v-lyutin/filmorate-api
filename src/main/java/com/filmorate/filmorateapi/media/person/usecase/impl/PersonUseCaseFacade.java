package com.filmorate.filmorateapi.media.person.usecase.impl;

import com.filmorate.filmorateapi.media.career.service.CareerService;
import com.filmorate.filmorateapi.media.person.mapper.PersonCreationRequestToPersonMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonPageToPersonPageResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.PersonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.PersonPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonUseCaseFacade implements PersonUseCase {
    private final PersonService personService;
    private final CareerService careerService;
    private final PersonPageToPersonPageResponseMapper personPageToPersonPageResponseMapper;
    private final PersonCreationRequestToPersonMapper personCreationRequestToPersonMapper;

    @Override
    public PersonPageResponse findPersons(PersonFindRequest personFindRequest) {
        Pageable pageable = PageRequest.of(personFindRequest.page(), personFindRequest.limit());
        Page<Person> pageablePersons = personService.findPersons(pageable);
        return personPageToPersonPageResponseMapper.map(pageablePersons);
    }

    @Override
    public void createPerson(PersonCreationRequest personCreationRequest) {
        Person person = personCreationRequestToPersonMapper.map(personCreationRequest);
        personService.createPerson(person);
    }
}
