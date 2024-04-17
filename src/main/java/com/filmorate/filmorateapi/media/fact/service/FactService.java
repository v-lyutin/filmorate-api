package com.filmorate.filmorateapi.media.fact.service;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import java.util.List;

public interface FactService {
    Fact createFact(Fact fact);

    Fact updateFact(Fact fact);

    Fact getFactById(Long factId);

    List<Fact> getFactsByFactTypeAndEntityId(FactType factType, Long entityId);

    void removeFactById(Long factId);

    void removeAllFactsByFactTypeAndEntityId(FactType factType, Long entityId);
}
