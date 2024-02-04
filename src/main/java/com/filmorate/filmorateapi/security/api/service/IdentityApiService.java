package com.filmorate.filmorateapi.security.api.service;

import com.filmorate.filmorateapi.security.api.model.CurrentUserAccountApiModel;
import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserAccountApiModel> currentUserAccount();
}
