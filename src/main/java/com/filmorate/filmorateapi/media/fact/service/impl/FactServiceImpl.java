package com.filmorate.filmorateapi.media.fact.service.impl;

import com.filmorate.filmorateapi.media.fact.exception.FactServiceException;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.repository.FactRepository;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.person.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FactServiceImpl implements FactService {
    private final FactRepository factRepository;

    @Override
    public Fact createFact(Fact fact) {
        return factRepository.save(fact);
    }

    @Override
    public Fact updateFact(Fact fact) {
        return factRepository.save(fact);
    }

    @Override
    public Fact getFactById(Long factId) {
        return factRepository.findById(factId)
                .orElseThrow(() -> new FactServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Fact with ID = %d not found", factId))
                );
    }

    @Override
    public List<Fact> getFactsByPerson(Person person) {
        return factRepository.findFactsByPerson(person);
    }

    @Override
    @Transactional
    public void removeAllFactsByPerson(Person person) {
        factRepository.removeAllByPerson(person);
    }

    @Override
    @Transactional
    public void removeFactByIdAndPerson(Person person, Long factId) {
        factRepository.removeFactByIdAndPerson(factId, person);
    }
}
