package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactToFactDemoResponseMapper;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.fact.web.dto.FactDemoResponse;
import com.filmorate.filmorateapi.media.person.mapper.PersonToPersonResponseMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonToPersonResponseMapperImpl implements PersonToPersonResponseMapper {
    private final FactService factService;
    private final FactToFactDemoResponseMapper factToFactDemoResponseMapper;

    @Override
    public PersonResponse map(Person person) {
        List<FactDemoResponse> mappedFacts = factService.getFactsByPerson(person).stream()
                .map(factToFactDemoResponseMapper::map)
                .collect(Collectors.toList());

        return new PersonResponse(
                person.getId(),
                person.getImageLink(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getCountryOfBirth(),
                person.getCityOfBirth(),
                person.getHeight(),
                person.getCareers(),
                mappedFacts
        );
    }
}
