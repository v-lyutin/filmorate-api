package com.filmorate.filmorateapi.media.person.usecase.impl;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.person.mapper.PersonAddCareersRequestToCareersMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonCreationRequestToPersonMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonPageToPersonsPageResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.PersonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PersonUseCaseFacade implements PersonUseCase {
    private final PersonService personService;
    private final PersonAddCareersRequestToCareersMapper personAddCareersRequestToCareersMapper;
    private final PersonPageToPersonsPageResponseMapper personPageToPersonPageResponseMapper;
    private final PersonCreationRequestToPersonMapper personCreationRequestToPersonMapper;

    @Override
    public PersonsPageResponse findPersons(PersonFindRequest personFindRequest) {
        Pageable pageable = PageRequest.of(personFindRequest.page(), personFindRequest.limit());
        Page<Person> pageablePersons = personService.findPersons(pageable);
        return personPageToPersonPageResponseMapper.map(pageablePersons);
    }

    @Override
    public Person getPerson(Long personId) {
        return personService.getPersonById(personId);
    }

    @Override
    public void createPerson(PersonCreationRequest personCreationRequest) {
        Person person = personCreationRequestToPersonMapper.map(personCreationRequest);
        personService.createPerson(person);
    }

    @Override
    public void addImageLink(Long personId, PersonAddImageLinkRequest personAddImageLinkRequest) {
        Person person = personService.getPersonById(personId);
        person.setImageLink(personAddImageLinkRequest.imageLink());
        personService.updatePerson(person);
    }

    @Override
    public void deleteImageLink(Long personId) {
        Person person = personService.getPersonById(personId);
        person.setImageLink(null);
        personService.updatePerson(person);
    }

    @Override
    public void addPersonCareers(Long personId, PersonAddCareersRequest personAddCareersRequest) {
        Set<Career> careers = personAddCareersRequestToCareersMapper.map(personAddCareersRequest);
        Person person = personService.getPersonById(personId);
        person.setCareers(careers);
        personService.updatePerson(person);
    }

    @Override
    public void deletePersonCareers(Long personId) {
        Person person = personService.getPersonById(personId);
        person.getCareers().clear();
        personService.updatePerson(person);
    }
}
