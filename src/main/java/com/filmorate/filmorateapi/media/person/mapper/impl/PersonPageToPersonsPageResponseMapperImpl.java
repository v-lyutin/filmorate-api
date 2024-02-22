package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.person.mapper.PersonPageToPersonsPageResponseMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonDemoResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonPageToPersonsPageResponseMapperImpl implements PersonPageToPersonsPageResponseMapper {
    private final PersonToPersonDemoResponseMapper personToPersonDemoResponseMapper;

    @Override
    public PersonsPageResponse map(Page<Person> pageablePersons) {
        return new PersonsPageResponse(
                pageablePersons.getTotalPages(),
                pageablePersons.isFirst(),
                pageablePersons.isLast(),
                personToPersonDemoResponseMapper.map(pageablePersons.getContent())
        );
    }
}
