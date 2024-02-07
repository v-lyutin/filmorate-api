package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonCreationRequestToPersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.PersonCreationRequest;
import org.springframework.stereotype.Component;

@Component
public class PersonCreationRequestToPersonMapperImpl implements PersonCreationRequestToPersonMapper {
    @Override
    public Person map(PersonCreationRequest personCreationRequest) {
        Person person = new Person();
        person.setFirstName(personCreationRequest.firstName());
        person.setLastName(personCreationRequest.lastName());
        person.setBirthDate(personCreationRequest.birthDate());
        person.setHeight(personCreationRequest.height());
        return person;
    }
}
