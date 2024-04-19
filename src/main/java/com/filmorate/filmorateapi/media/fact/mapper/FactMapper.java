package com.filmorate.filmorateapi.media.fact.mapper;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;

public interface FactMapper {
    Fact map(FactType factType, FactRequest request);

    FactResponse map(Fact fact);
}
