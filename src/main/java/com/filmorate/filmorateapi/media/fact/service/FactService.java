package com.filmorate.filmorateapi.media.fact.service;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.person.model.Person;
import java.util.List;

public interface FactService {
    Fact createFact(Fact fact);

    Fact updateFact(Fact fact);

    Fact getFactById(Long factId);

    List<Fact> getFactsByPerson(Person person);

    void removeAllFactsByPerson(Person person);

    void removeFactByIdAndPerson(Person person, Long factId);
}
