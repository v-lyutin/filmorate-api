package com.filmorate.filmorateapi.media.person.usecase.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.model.Person_;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.PersonUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.filter.PersonFilter;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonFindRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonUseCaseFacade implements PersonUseCase {
    private final PersonService personService;
    private final PersonMapper personMapper;

    @Override
    public PersonResponse createPerson(PersonCreationRequest request) {
        Person person = personMapper.toPerson(request);
        Person createdPerson = personService.createPerson(person);
        return personMapper.toPersonResponse(createdPerson);
    }

    @Override
    public PersonResponse updatePerson(Long personId, PersonUpdateRequest request) {
        Person person = personService.getPersonById(personId);
        personMapper.update(request, person);
        return personMapper.toPersonResponse(personService.updatePerson(person));
    }

    @Override
    public PersonResponse getPersonById(Long personId) {
        Person person = personService.getPersonById(personId);
        return personMapper.toPersonResponse(person);
    }

    @Override
    public PersonsPageResponse getPersonsWithFilters(PersonFilter personFilter, PersonFindRequest request) {
        Pageable pageable = PageRequest.of(request.page(), request.limit(), Sort.by(Sort.Order.by(Person_.NAME)));
        Page<Person> pageablePersons = personService.getPersons(personFilter, pageable);
        return personMapper.toPersonsPageResponse(pageablePersons);
    }

    @Override
    public void removePersonById(Long personId) {
        personService.removePersonById(personId);
    }
}
