package com.filmorate.filmorateapi.security.web.dto.request;

import java.util.Set;

public record AuthorityRequest(
        Set<String> authorities) {
}
