package com.filmorate.filmorateapi.media.person.api.impl;

import com.filmorate.filmorateapi.media.person.api.PersonApiService;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonApiServiceImpl implements PersonApiService {
    private final PersonService personService;

    @Override
    public Person getPersonById(Long personId) {
        return personService.getPersonById(personId);
    }
}
