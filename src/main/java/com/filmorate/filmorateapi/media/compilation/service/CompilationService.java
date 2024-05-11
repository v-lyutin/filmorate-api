package com.filmorate.filmorateapi.media.compilation.service;

import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.series.model.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompilationService {
    Compilation createCompilation(Compilation compilation);

    Compilation updateCompilation(Compilation compilation);

    Page<Compilation> searchCompilations(Pageable pageable);

    Compilation getCompilationById(Long compilationId);

    void removeCompilationById(Long compilationId);

    Long getCompilationLikeCount(Long compilationId);

    void toggleLike(Long compilationId);

    void toggleMovie(Long compilationId, Movie movie);

    void toggleSeries(Long compilationId, Series series);
}
