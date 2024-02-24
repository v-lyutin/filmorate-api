package com.filmorate.filmorateapi.media.fact.usecase.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactAddRequestToFactMapper;
import com.filmorate.filmorateapi.media.fact.mapper.FactToFactResponseMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.web.dto.FactAddRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FactUseCaseFacade implements FactUseCase {
    private final FactAddRequestToFactMapper factAddRequestToFactMapper;
    private final FactToFactResponseMapper factToFactResponseMapper;
    private final FactService factService;

    @Override
    public FactResponse addFact(Long personId, FactAddRequest request) {
        Fact mappedFact = factAddRequestToFactMapper.map(request);
        Fact createdFact = factService.createFact(mappedFact);
        return factToFactResponseMapper.map(createdFact);
    }
}
