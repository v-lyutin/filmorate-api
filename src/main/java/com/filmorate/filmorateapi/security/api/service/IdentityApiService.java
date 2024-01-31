package com.filmorate.filmorateapi.security.api.service;

import com.filmorate.filmorateapi.security.api.model.CurrentUserApiModel;
import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
