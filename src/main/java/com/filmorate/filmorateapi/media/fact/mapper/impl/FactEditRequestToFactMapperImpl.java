package com.filmorate.filmorateapi.media.fact.mapper.impl;

import com.filmorate.filmorateapi.media.fact.mapper.FactEditRequestToFactMapper;
import com.filmorate.filmorateapi.media.fact.model.Fact;
import com.filmorate.filmorateapi.media.fact.service.FactService;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FactEditRequestToFactMapperImpl implements FactEditRequestToFactMapper {
    private final FactService factService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Fact map(Long factId, FactRequest request) {
        Fact currentFact = factService.getFactById(factId);
        currentFact.setText(request.text());
        currentFact.setEditedBy(currentUserProfileApiService.currentUserProfile().getNickname());
        return currentFact;
    }
}
