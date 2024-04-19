package com.filmorate.filmorateapi.media.fact.usecase.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.model.FactType;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.fact.usecase.FactUseCase;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import com.filmorate.filmorateapi.media.fact.web.dto.FactUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FactUseCaseFacade implements FactUseCase {
    private final FactService factService;
    private final FactMapper factMapper;

    @Override
    public FactResponse createFact(FactType factType, FactRequest request) {
        Fact fact = factMapper.map(factType, request);
        return factMapper.map(factService.createFact(fact));
    }

    @Override
    public FactResponse updateFact(Long factId, FactUpdateRequest request) {
        Fact fact = factService.getFactById(factId);
        fact.setText(request.text());
        return factMapper.map(fact);
    }

    @Override
    public FactResponse getFactById(Long factId) {
        Fact fact = factService.getFactById(factId);
        return factMapper.map(fact);
    }

    @Override
    public List<FactResponse> getAllFactsByFactTypeAndEntityId(FactType factType, Long entityId) {
        List<Fact> facts = factService.getFactsByFactTypeAndEntityId(factType, entityId);
        return facts.stream()
                .map(factMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void removeFactById(Long factId) {
        factService.removeFactById(factId);
    }

    @Override
    public void removeAllFactsByFactTypeAndEntityId(FactType factType, Long entityId) {
        factService.removeAllFactsByFactTypeAndEntityId(factType, entityId);
    }
}
