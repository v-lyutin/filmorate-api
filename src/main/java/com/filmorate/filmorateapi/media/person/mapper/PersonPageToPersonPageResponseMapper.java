package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.PersonPageResponse;
import org.springframework.data.domain.Page;

public interface PersonPageToPersonPageResponseMapper extends Mapper<PersonPageResponse, Page<Person>> {
}
