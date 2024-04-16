package com.filmorate.filmorateapi.media.fact.usecase.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactEditRequestToFactMapper;
import com.filmorate.filmorateapi.media.fact.mapper.FactRequestToFactMapper;
import com.filmorate.filmorateapi.media.fact.mapper.FactToFactResponseMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import com.filmorate.filmorateapi.media.person.exception.PersonServiceException;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FactUseCaseFacade implements FactUseCase {
    private final FactRequestToFactMapper factRequestToFactMapper;
    private final FactToFactResponseMapper factToFactResponseMapper;
    private final FactEditRequestToFactMapper factEditRequestToFactMapper;
    private final FactService factService;
    private final PersonService personService;

    @Override
    public FactResponse addFact(Long personId, FactRequest request) {
        Fact mappedFact = factRequestToFactMapper.map(personId, request);
        Fact createdFact = factService.createFact(mappedFact);
        return factToFactResponseMapper.map(createdFact);
    }

    @Override
    public FactResponse editFact(Long personId, Long factId, FactRequest request) {
        Fact mappedFact = factEditRequestToFactMapper.map(factId, request);
        Fact editedFact = factService.updateFact(mappedFact);
        return factToFactResponseMapper.map(editedFact);
    }

    @Override
    public List<FactResponse> getFactsByPersonId(Long personId) {
        Person person = personService.getPersonById(personId);
        return factService.getFactsByPerson(person).stream()
                .map(factToFactResponseMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void removeFact(Long personId, Long factId) {
        Person person = personService.getPersonById(personId);
        factService.removeFactByIdAndPerson(person, factId);
    }

    @Override
    public void removeAllFactsByPersonId(Long personId) {
        Person person = personService.getPersonById(personId);
        factService.removeAllFactsByPerson(person);
    }
}
