package com.filmorate.filmorateapi.media.fact.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactToFactResponseMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import org.springframework.stereotype.Component;

@Component
public class FactToFactResponseMapperImpl implements FactToFactResponseMapper {
    @Override
    public FactResponse map(Fact fact) {
        return new FactResponse(
                fact.getId(),
                fact.getText(),
                fact.getCreatedAt(),
                fact.getCreatedBy(),
                fact.getEditedAt(),
                fact.getEditedBy()
        );
    }
}
