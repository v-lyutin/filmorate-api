package com.filmorate.filmorateapi.media.career.usecase.impl;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import com.filmorate.filmorateapi.media.career.usecase.CareerUseCase;
import com.filmorate.filmorateapi.media.career.web.dto.CareerCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CareerUseCaseFacade implements CareerUseCase {
    private final CareerService careerService;

    @Override
    public Collection<Career> getAllCareers() {
        return careerService.getAllCareers();
    }

    @Override
    public Career getCareerById(Long careerId) {
        return careerService.findCareerById(careerId);
    }

    @Override
    public void createCareer(CareerCreationRequest careerCreationRequest) {
        Career career = new Career();
        career.setName(careerCreationRequest.name());
        careerService.createCareer(career);
    }

    @Override
    public void updateCareer(Long careerId, CareerCreationRequest careerCreationRequest) {
        Career career = careerService.findCareerById(careerId);
        career.setName(careerCreationRequest.name());
        careerService.updateCareer(career);
    }

    @Override
    public void deleteCareer(Long careerId) {
        careerService.deleteCareer(careerId);
    }
}
