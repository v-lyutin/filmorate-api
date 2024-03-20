package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonDemoResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PersonToPersonDemoResponseMapperImpl implements PersonToPersonDemoResponseMapper {
    @Override
    public List<PersonDemoResponse> map(List<Person> persons) {
        return persons.stream()
                .map(person -> new PersonDemoResponse(
                        person.getId(),
                        person.getImageLink(),
                        person.getName(),
                        careersToString(person.getCareers())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDemoResponse map(Person person) {
        return new PersonDemoResponse(
                person.getId(),
                person.getImageLink(),
                person.getName(),
                careersToString(person.getCareers())
        );
    }

    private List<String> careersToString(Set<Career> careers) {
        return careers.stream()
                .map(Career::getName)
                .collect(Collectors.toList());
    }
}
