package com.filmorate.filmorateapi.media.career.service.impl;

import com.filmorate.filmorateapi.media.career.exception.CareerServiceException;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.career.repository.CareerRepository;
import com.filmorate.filmorateapi.media.career.service.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
                .orElseThrow(() -> new CareerServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Career with ID = '%d' not found", careerId)));
    }

    @Override
    public Career findCareerByName(String careerName) {
        return careerRepository.findByName(careerName.toLowerCase())
                .orElseThrow(() -> new CareerServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Career with name '%s' not found", careerName)));
    }

    @Override
    public Career createCareer(Career career) {
        if (careerRepository.existsByNameContainingIgnoreCase(career.getName())) {
            throw new CareerServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Career with name '%s' is already exists", career.getName()));
        }
        return careerRepository.save(career);
    }

    @Override
    public Career updateCareer(Career career) {
        if (careerRepository.existsByNameContainingIgnoreCase(career.getName())) {
            throw new CareerServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Career with name '%s' is already exists", career.getName()));
        }
        return careerRepository.save(career);
    }

    @Override
    public void deleteCareer(Long careerId) {
        careerRepository.deleteById(careerId);
    }
}
