package com.filmorate.filmorateapi.media.person.usecase.career.impl;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import com.filmorate.filmorateapi.media.person.mapper.PersonAddCareersRequestToCareersMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.person.usecase.career.PersonCareerUseCase;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonAddCareerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PersonCareerUseCaseFacade implements PersonCareerUseCase {
    private final PersonAddCareersRequestToCareersMapper personAddCareersRequestToCareersMapper;
    private final PersonService personService;
    private final CareerService careerService;

    @Override
    public void addCareers(Long personId, PersonAddCareerRequest request) {
        Set<Career> careers = personAddCareersRequestToCareersMapper.map(request);
        Person person = personService.getPersonById(personId);
        person.getCareers().addAll(careers);
        personService.updatePerson(person);
    }

    @Override
    public void removeAllCareers(Long personId) {
        Person person = personService.getPersonById(personId);
        person.getCareers().clear();
        personService.updatePerson(person);
    }

    @Override
    public void removeCareerById(Long personId, Long careerId) {
        Person person = personService.getPersonById(personId);
        Career requiredCareer = careerService.findCareerById(careerId);
        person.getCareers().removeIf(
                career -> career.getId().equals(requiredCareer.getId())
        );
        personService.updatePerson(person);
    }
}
