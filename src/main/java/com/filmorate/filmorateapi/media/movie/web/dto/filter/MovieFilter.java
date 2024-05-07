package com.filmorate.filmorateapi.media.movie.web.dto.filter;

import com.filmorate.filmorateapi.media.genre.model.Genre_;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.model.Movie_;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
public class MovieFilter implements Specification<Movie> {
    private String title;
    private String originalTitle;
    private String releaseYear;
    private String country;
    private String duration;
    private Set<String> genres;

    @Override
    public Predicate toPredicate(@NonNull Root<Movie> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(title)) {
            predicates.add(criteriaBuilder.like(root.get(Movie_.TITLE), "%" + title + "%"));
        }
        if (StringUtils.isNotBlank(originalTitle)) {
            predicates.add(criteriaBuilder.like(root.get(Movie_.ORIGINAL_TITLE), "%" + originalTitle + "%"));
        }
        if (StringUtils.isNotBlank(releaseYear)) {
            predicates.add(criteriaBuilder.equal(root.get(Movie_.RELEASE_YEAR), releaseYear));
        }
        if (StringUtils.isNotBlank(country)) {
            predicates.add(criteriaBuilder.like(root.get(Movie_.COUNTRY), "%" + country + "%"));
        }
        if (StringUtils.isNotBlank(duration)) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Movie_.DURATION), duration));
        }
        if (genres != null && !genres.isEmpty()) {
            for (String genre : genres) {
                predicates.add(criteriaBuilder.equal(root.join(Movie_.GENRES).get(Genre_.NAME), genre));
            }
        }
        return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
