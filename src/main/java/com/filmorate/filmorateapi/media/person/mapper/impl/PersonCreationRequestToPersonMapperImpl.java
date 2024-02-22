package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonCreationRequestToPersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import org.springframework.stereotype.Component;

@Component
public class PersonCreationRequestToPersonMapperImpl implements PersonCreationRequestToPersonMapper {
    @Override
    public Person map(PersonCreationRequest personCreationRequest) {
        return Person.builder()
                .imageLink(personCreationRequest.imageLink())
                .firstName(personCreationRequest.firstName())
                .lastName(personCreationRequest.lastName())
                .birthDate(personCreationRequest.birthDate())
                .countryOfBirth(personCreationRequest.countryOfBirth())
                .cityOfBirth(personCreationRequest.cityOfBirth())
                .height(personCreationRequest.height())
                .build();
    }
}
