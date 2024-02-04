package com.filmorate.filmorateapi.common.mapper;

public interface Mapper<D, S> {
    D map (S source);
}
