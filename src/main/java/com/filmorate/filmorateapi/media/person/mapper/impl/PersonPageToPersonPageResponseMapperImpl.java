package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonPageToPersonPageResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.PersonPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PersonPageToPersonPageResponseMapperImpl implements PersonPageToPersonPageResponseMapper {
    @Override
    public PersonPageResponse map(Page<Person> pageablePersons) {
        return new PersonPageResponse(
                pageablePersons.getTotalPages(),
                pageablePersons.isFirst(),
                pageablePersons.isLast(),
                pageablePersons.getContent()
        );
    }
}
