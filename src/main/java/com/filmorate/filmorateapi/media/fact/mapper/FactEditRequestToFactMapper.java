package com.filmorate.filmorateapi.media.fact.mapper;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;

public interface FactEditRequestToFactMapper {
    Fact map(Long factId, FactRequest request);
}
