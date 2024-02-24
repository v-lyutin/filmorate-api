package com.filmorate.filmorateapi.media.fact.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactAddRequestToFactMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.web.dto.FactAddRequest;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FactAddRequestToFactMapperImpl implements FactAddRequestToFactMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final PersonService personService;

    @Override
    public Fact map(Long personId, FactAddRequest request) {
        Fact fact = new Fact();
        fact.setPerson(personService.getPersonById(personId));
        fact.setText(request.text());
        fact.setCreatedBy(currentUserProfileApiService.currentUserProfile().getNickname());
        return fact;
    }
}
