package com.filmorate.filmorateapi.media.fact.service.impl;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.repository.FactRepository;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FactServiceImpl implements FactService {
    private final FactRepository factRepository;

    @Override
    public Fact createFact(Fact fact) {
        return factRepository.save(fact);
    }
}
