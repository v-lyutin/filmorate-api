package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.person.mapper.PersonUpdateMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateInfoRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonUpdateMapperImpl extends PersonUpdateMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public void update(PersonUpdateInfoRequest request, Person person) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.firstName())) {
            person.setFirstName(jsonNullableMapper.unwrap(request.firstName()));
        }
        if (jsonNullableMapper.isPresent(request.lastName())) {
            person.setLastName(jsonNullableMapper.unwrap(request.lastName()));
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
