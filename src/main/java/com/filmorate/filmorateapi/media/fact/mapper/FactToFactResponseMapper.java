package com.filmorate.filmorateapi.media.fact.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;

public interface FactToFactResponseMapper extends Mapper<FactResponse, Fact> {
}
