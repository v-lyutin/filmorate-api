package com.filmorate.filmorateapi.media.movie.mapper;

import com.filmorate.filmorateapi.media.movie.web.dto.filter.MovieFilter;
import com.filmorate.filmorateapi.media.movie.web.dto.request.MovieFindRequest;

public interface MovieFilterMapper {
    MovieFilter map(MovieFindRequest request);
}
