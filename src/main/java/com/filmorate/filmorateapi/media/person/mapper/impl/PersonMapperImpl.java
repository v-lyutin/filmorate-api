package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import com.filmorate.filmorateapi.media.person.mapper.PersonMapper;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonCreationRequest;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonUpdateRequest;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonPreviewResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonResponse;
import com.filmorate.filmorateapi.media.person.web.dto.response.PersonsPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonMapperImpl implements PersonMapper {
    private final CareerService careerService;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Person toPerson(PersonCreationRequest request) {
        return Person.builder()
                .imageLink(request.imageLink())
                .name(request.name())
                .enName(request.enName())
                .birthDate(request.birthDate())
                .countryOfBirth(request.countryOfBirth())
                .cityOfBirth(request.cityOfBirth())
                .height(request.height())
                .careers(parseCareers(request.careers()))
                .build();
    }

    @Override
    public PersonResponse toPersonResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getImageLink(),
                person.getName(),
                person.getEnName(),
                person.getBirthDate(),
                person.getCountryOfBirth(),
                person.getCityOfBirth(),
                person.getHeight(),
                careersToString(person.getCareers()));
    }

    @Override
    public PersonsPageResponse toPersonsPageResponse(Page<Person> pageablePersons) {
        List<PersonPreviewResponse> personPreviews = pageablePersons.getContent().stream()
                .map(this::toPersonPreviewResponse)
                .toList();
        return new PersonsPageResponse(
                pageablePersons.getTotalPages(),
                pageablePersons.isFirst(),
                pageablePersons.isLast(),
                pageablePersons.getTotalElements(),
                personPreviews
        );
    }

    @Override
    public PersonPreviewResponse toPersonPreviewResponse(Person person) {
        return new PersonPreviewResponse(
                person.getId(),
                person.getImageLink(),
                person.getName(),
                person.getEnName(),
                careersToString(person.getCareers())
        );
    }

    @Override
    public void update(PersonUpdateRequest request, Person person) {
        if (request == null) {
            return;
        }
        if (jsonNullableMapper.isPresent(request.imageLink())) {
            person.setImageLink(jsonNullableMapper.unwrap(request.imageLink()));
        }
        if (jsonNullableMapper.isPresent(request.name())) {
            person.setName(jsonNullableMapper.unwrap(request.name()));
        }
        if (jsonNullableMapper.isPresent(request.enName())) {
            person.setName(jsonNullableMapper.unwrap(request.enName()));
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
        if (jsonNullableMapper.isPresent(request.careers())) {
            Set<Career> careers = parseCareers(jsonNullableMapper.unwrap(request.careers()));
            person.setCareers(careers);
        }
    }

    private Set<String> careersToString(Set<Career> careers) {
        return careers.stream()
                .map(Career::getName)
                .collect(Collectors.toSet());
    }

    private Set<Career> parseCareers(Set<String> careers) {
        return careers.stream()
                .map(careerService::findCareerByName)
                .collect(Collectors.toSet());
    }
}
