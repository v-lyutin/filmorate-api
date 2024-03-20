package com.filmorate.filmorateapi.media.career.mapper.impl;

import com.filmorate.filmorateapi.media.career.mapper.CareerFromStringMapper;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CareerFromStringMapperImpl implements CareerFromStringMapper {
    private final CareerService careerService;

    @Override
    public Career map(String source) {
        return careerService.findCareerByName(source);
    }
}
