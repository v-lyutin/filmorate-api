package com.filmorate.filmorateapi.media.fact.service;

import com.filmorate.filmorateapi.media.fact.model.Fact;

public interface FactService {
    Fact createFact(Fact fact);

    Fact updateFact(Fact fact);

    Fact getFactById(Long factId);
}
