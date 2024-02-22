package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PersonToPersonDemoResponseMapperImpl implements PersonToPersonDemoResponseMapper {
    @Override
    public List<PersonDemoResponse> map(List<Person> persons) {
        return persons.stream()
                .map(person -> new PersonDemoResponse(
                        person.getId(),
                        person.getImageLink(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getCareers()
                ))
                .toList();
    }
}
