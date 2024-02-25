package com.filmorate.filmorateapi.media.fact.usecase;

import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;

public interface FactUseCase {
    FactResponse addFact(Long personId, FactRequest request);

    FactResponse editFact(Long personId, Long factId, FactRequest request);
}
