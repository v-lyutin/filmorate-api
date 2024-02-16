package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateInfoRequest;
import org.mapstruct.*;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class PersonUpdateMapper {
    public abstract void update(PersonUpdateInfoRequest request, @MappingTarget Person person);
}
