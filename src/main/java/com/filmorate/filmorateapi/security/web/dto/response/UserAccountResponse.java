package com.filmorate.filmorateapi.security.web.dto.response;

import com.filmorate.filmorateapi.security.model.UserRole;
import java.util.Set;

public record UserAccountResponse(
        long id,

        String email,

        Set<UserRole> authorities) {
}
