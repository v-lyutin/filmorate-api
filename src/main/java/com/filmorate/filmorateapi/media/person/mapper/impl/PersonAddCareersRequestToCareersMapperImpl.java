package com.filmorate.filmorateapi.media.person.mapper.impl;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import com.filmorate.filmorateapi.media.person.mapper.PersonAddCareersRequestToCareersMapper;
import com.filmorate.filmorateapi.media.person.web.dto.request.PersonAddCareerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonAddCareersRequestToCareersMapperImpl implements PersonAddCareersRequestToCareersMapper {
    private final CareerService careerService;

    @Override
    public Set<Career> map(PersonAddCareerRequest personAddCareersRequest) {
        return personAddCareersRequest.careers().stream()
                .map(careerService::findCareerByName)
                .collect(Collectors.toSet());
    }
}
