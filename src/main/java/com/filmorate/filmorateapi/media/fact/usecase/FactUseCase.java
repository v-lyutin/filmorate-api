package com.filmorate.filmorateapi.media.fact.usecase;

import com.filmorate.filmorateapi.media.fact.model.FactType;
import com.filmorate.filmorateapi.media.fact.web.dto.FactRequest;
import com.filmorate.filmorateapi.media.fact.web.dto.FactResponse;
import com.filmorate.filmorateapi.media.fact.web.dto.FactUpdateRequest;
import java.util.List;

public interface FactUseCase {
    FactResponse createFact(FactType factType, FactRequest request);

    FactResponse updateFact(Long factId, FactUpdateRequest request);

    FactResponse getFactById(Long factId);

    List<FactResponse> getAllFactsByFactTypeAndEntityId(FactType factType, Long entityId);

    void removeFactById(Long factId);

    void removeAllFactsByFactTypeAndEntityId(FactType factType, Long entityId);
}
