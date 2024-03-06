package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonCreationResponse;

public interface PersonToPersonCreationResponseMapper extends Mapper<PersonCreationResponse, Person> {
}
