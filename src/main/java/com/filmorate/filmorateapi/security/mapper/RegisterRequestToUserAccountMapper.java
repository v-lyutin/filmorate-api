package com.filmorate.filmorateapi.security.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.security.model.UserAccount;
import com.filmorate.filmorateapi.security.web.dto.request.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}
