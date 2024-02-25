package com.filmorate.filmorateapi.media.fact.usecase;

import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import java.util.List;

public interface FactUseCase {
    FactResponse addFact(Long personId, FactRequest request);

    FactResponse editFact(Long personId, Long factId, FactRequest request);

    List<FactResponse> getFactsByPersonId(Long personId);
}
