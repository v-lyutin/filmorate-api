package com.filmorate.filmorateapi.media.fact.mapper;

import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactAddRequest;

public interface FactAddRequestToFactMapper {
    Fact map(Long personId, FactAddRequest request);
}
