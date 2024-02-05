package com.filmorate.filmorateapi.media.career.service.impl;

import com.filmorate.filmorateapi.media.career.exception.CareerServiceException;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.repository.CareerRepository;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {
    private final CareerRepository careerRepository;

    @Override
    public Collection<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    @Override
    public Career findCareerById(Long careerId) {
        return careerRepository.findById(careerId)
                .orElseThrow(() -> new CareerServiceException(String.format("Карьеры с ID = {%d} не существует", careerId)));
    }

    @Override
    public void createCareer(Career career) {
        if (careerRepository.existsByName(career.getName())) {
            throw new CareerServiceException("Карьера с таким названием уже существует");
        }
        careerRepository.save(career);
    }

    @Override
    public void updateCareer(Career updatedCareer) {
        if (careerRepository.existsByName(updatedCareer.getName())) {
            throw new CareerServiceException("Карьера с таким названием уже существует");
        }
        Career career = careerRepository.findById(updatedCareer.getId())
                .orElseThrow(() -> new CareerServiceException(
                        String.format("Карьеры с ID = {%d} не существует", updatedCareer.getId()))
                );
        career.setName(updatedCareer.getName());
        careerRepository.save(career);
    }

    @Override
    public void deleteCareer(Long careerId) {
        careerRepository.deleteById(careerId);
    }
}
