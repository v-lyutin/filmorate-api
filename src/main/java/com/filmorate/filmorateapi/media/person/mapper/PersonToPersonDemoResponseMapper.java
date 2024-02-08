package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.PersonDemoResponse;
import java.util.List;

public interface PersonToPersonDemoResponseMapper extends Mapper<List<PersonDemoResponse>, List<Person>> {
}
