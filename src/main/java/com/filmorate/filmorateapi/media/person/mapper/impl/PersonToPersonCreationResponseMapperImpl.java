package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonCreationResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonCreationResponse;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonCreationResponseMapperImpl implements PersonToPersonCreationResponseMapper {
    @Override
    public PersonCreationResponse map(Person person) {
        return new PersonCreationResponse(
                person.getId(),
                person.getImageLink(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getCountryOfBirth(),
                person.getCityOfBirth(),
                person.getHeight()
                );
    }
}
