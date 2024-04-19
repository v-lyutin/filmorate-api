package com.filmorate.filmorateapi.media.genre.mapper;

import com.filmorate.filmorateapi.common.mapper.Mapper;
import com.filmorate.filmorateapi.media.genre.model.Genre;
import com.filmorate.filmorateapi.media.genre.web.dto.GenreResponse;

public interface GenreToGenreResponseMapper extends Mapper<GenreResponse, Genre> {
}
