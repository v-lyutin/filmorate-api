package com.filmorate.filmorateapi.media.fact.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactToFactDemoResponseMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactDemoResponse;
import org.springframework.stereotype.Component;

@Component
public class FactToFactDemoResponseMapperImpl implements FactToFactDemoResponseMapper {
    @Override
    public FactDemoResponse map(Fact fact) {
        return new FactDemoResponse(
                fact.getId(),
                fact.getText()
        );
    }
}
