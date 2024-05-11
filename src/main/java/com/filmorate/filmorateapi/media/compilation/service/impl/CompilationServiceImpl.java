package com.filmorate.filmorateapi.media.compilation.service.impl;

import com.filmorate.filmorateapi.media.compilation.exception.CompilationServiceException;
import com.filmorate.filmorateapi.media.compilation.model.Compilation;
import com.filmorate.filmorateapi.media.compilation.repository.CompilationRepository;
import com.filmorate.filmorateapi.media.compilation.service.CompilationService;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.user.api.CurrentUserProfileApiService;
import com.filmorate.filmorateapi.user.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompilationServiceImpl implements CompilationService {
    private final CompilationRepository compilationRepository;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Compilation createCompilation(Compilation compilation) {
        UserProfile author = currentUserProfileApiService.currentUserProfile();
        compilation.setUserProfile(author);
        return compilationRepository.save(compilation);
    }

    @Override
    public Compilation updateCompilation(Compilation compilation) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = compilation.getUserProfile();
        if (!Objects.equals(actor.getId(), owner.getId())) {
            throw new CompilationServiceException(
                    HttpStatus.FORBIDDEN,
                    "Access denied"
            );
        }
        return compilationRepository.save(compilation);
    }

    @Override
    public Page<Compilation> searchCompilations(Pageable pageable) {
        return compilationRepository.findAll(pageable);
    }

    @Override
    public Compilation getCompilationById(Long compilationId) {
        return compilationRepository.findById(compilationId)
                .orElseThrow(() -> new CompilationServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Compilation with ID = '%d' not found", compilationId)));
    }

    @Override
    public void removeCompilationById(Long compilationId) {
        Compilation compilation = getCompilationById(compilationId);
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = compilation.getUserProfile();
        if (!Objects.equals(actor.getId(), owner.getId())) {
            throw new CompilationServiceException(
                    HttpStatus.FORBIDDEN,
                    "Access denied"
            );
        }
        compilationRepository.deleteById(compilationId);
    }

    @Override
    public Long getCompilationLikeCount(Long compilationId) {
        return compilationRepository.getCompilationLikeCount(compilationId);
    }

    @Override
    public void toggleLike(Long compilationId) {
        Compilation compilation = getCompilationById(compilationId);
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Set<UserProfile> likes = compilation.getLikedByUsers();
        if (likes.contains(userProfile)) {
            likes.remove(userProfile);
        } else {
            likes.add(userProfile);
        }
        compilationRepository.save(compilation);
    }

    @Override
    public void toggleMovie(Long compilationId, Movie movie) {
        Compilation compilation = getCompilationById(compilationId);
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = compilation.getUserProfile();
        if (!Objects.equals(actor.getId(), owner.getId())) {
            throw new CompilationServiceException(
                    HttpStatus.FORBIDDEN,
                    "Access denied"
            );
        }
        Set<Movie> movies = compilation.getMovies();
        if (!movies.contains(movie)) {
            movies.add(movie);
        } else {
            movies.remove(movie);
        }
        compilationRepository.save(compilation);
    }

    @Override
    public void toggleSeries(Long compilationId, Series series) {
        Compilation compilation = getCompilationById(compilationId);
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile owner = compilation.getUserProfile();
        if (!Objects.equals(actor.getId(), owner.getId())) {
            throw new CompilationServiceException(
                    HttpStatus.FORBIDDEN,
                    "Access denied"
            );
        }
        Set<Series> seriesSet = compilation.getSeries();
        if (!seriesSet.contains(series)) {
            seriesSet.add(series);
        } else {
            seriesSet.remove(series);
        }
        compilationRepository.save(compilation);
    }
}
