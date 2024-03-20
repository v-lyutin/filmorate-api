package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.event.EventType;
import com.filmorate.filmorateapi.media.person.mapper.PersonFromStringMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonFromStringMapperImpl implements PersonFromStringMapper {
    private final PersonService personService;

    @Override
    public Person map(String source) {
        if (!personService.existsByName(source)) {
            Person person = Person.builder()
                    .name(source)
                    .eventType(EventType.PENDING)
                    .build();
            return personService.createPerson(person);
        }
        return personService.getPersonByName(source);
    }
}
