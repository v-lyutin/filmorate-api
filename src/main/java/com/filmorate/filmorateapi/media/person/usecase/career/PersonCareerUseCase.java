package com.filmorate.filmorateapi.media.person.usecase.career;

import com.filmorate.filmorateapi.media.person.web.dto.request.PersonAddCareerRequest;

public interface PersonCareerUseCase {
    void addCareers(Long personId, PersonAddCareerRequest request);

    void removeAllCareers(Long personId);

    void removeCareerById(Long personId, Long careerId);
}
