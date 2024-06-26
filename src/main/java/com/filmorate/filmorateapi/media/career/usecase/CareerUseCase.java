package com.filmorate.filmorateapi.media.career.usecase;

import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.web.dto.CareerCreationRequest;
import java.util.Collection;

public interface CareerUseCase {
    Collection<Career> getAllCareers();

    Career getCareerById(Long careerId);

    Career createCareer(CareerCreationRequest careerCreationRequest);

    Career updateCareer(Long careerId, CareerCreationRequest careerCreationRequest);

    void deleteCareer(Long careerId);
}
