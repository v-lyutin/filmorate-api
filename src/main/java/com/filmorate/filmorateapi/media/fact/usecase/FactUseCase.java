package com.filmorate.filmorateapi.media.fact.usecase;

import com.filmorate.filmorateapi.media.fact.web.dto.FactAddRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;

public interface FactUseCase {
    FactResponse addFact(Long personId, FactAddRequest request);
}
