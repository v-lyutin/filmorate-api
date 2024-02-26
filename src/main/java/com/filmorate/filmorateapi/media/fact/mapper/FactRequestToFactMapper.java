package com.filmorate.filmorateapi.media.fact.mapper;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;

public interface FactRequestToFactMapper {
    Fact map(Long personId, FactRequest request);
}
