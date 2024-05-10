package com.filmorate.filmorateapi.media.person.api;

import com.filmorate.filmorateapi.media.person.model.Person;

public interface PersonApiService {
    Person getPersonById(Long personId);
}
