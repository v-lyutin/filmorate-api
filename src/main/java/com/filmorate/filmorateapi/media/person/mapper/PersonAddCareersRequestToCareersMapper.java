package com.filmorate.filmorateapi.media.person.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.career.model.Career;
import com.filmorate.filmorateapi.media.person.web.dto.PersonAddCareersRequest;
import java.util.Set;

public interface PersonAddCareersRequestToCareersMapper extends Mapper<Set<Career>, PersonAddCareersRequest> {
}
