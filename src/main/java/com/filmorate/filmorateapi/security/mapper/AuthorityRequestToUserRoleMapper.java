package com.filmorate.filmorateapi.security.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.security.model.UserRole;
import java.util.Set;

public interface AuthorityRequestToUserRoleMapper extends Mapper<Set<UserRole>, Set<String>> {
}
