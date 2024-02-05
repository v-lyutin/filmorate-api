package com.filmorate.filmorateapi.media.career.service;

import com.filmorate.filmorateapi.media.career.model.Career;
import java.util.Collection;

public interface CareerService {
    Collection<Career> getAllCareers();

    Career findCareerById(Long careerId);

    void createCareer(Career career);

    void updateCareer(Career updatedCareer);

    void deleteCareer(Long careerId);
}
