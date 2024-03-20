package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonUpdateMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonUpdateMapperImpl extends PersonUpdateMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public void map(PersonUpdateRequest request, Person person) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.imageLink())) {
            person.setImageLink(jsonNullableMapper.unwrap(request.imageLink()));
        }
        if (jsonNullableMapper.isPresent(request.name())) {
            person.setName(jsonNullableMapper.unwrap(request.name()));
        }
        if (jsonNullableMapper.isPresent(request.birthDate())) {
            person.setBirthDate(jsonNullableMapper.unwrap(request.birthDate()));
        }
        if (jsonNullableMapper.isPresent(request.countryOfBirth())) {
            person.setCountryOfBirth(jsonNullableMapper.unwrap(request.countryOfBirth()));
        }
        if (jsonNullableMapper.isPresent(request.cityOfBirth())) {
            person.setCityOfBirth(jsonNullableMapper.unwrap(request.cityOfBirth()));
        }
        if (jsonNullableMapper.isPresent(request.height())) {
            person.setHeight(jsonNullableMapper.unwrap(request.height()));
        }
    }
}
