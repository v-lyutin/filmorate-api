package com.filmorate.filmorateapi.media.series.web.dto.filter;

import com.filmorate.filmorateapi.media.genre.model.Genre_;
import com.filmorate.filmorateapi.media.rating.model.MPAARating;
import com.filmorate.filmorateapi.media.rating.model.MPAARating_;
import com.filmorate.filmorateapi.media.rating.model.RARSRating;
import com.filmorate.filmorateapi.media.rating.model.RARSRating_;
import com.filmorate.filmorateapi.media.series.model.Series;
import com.filmorate.filmorateapi.media.series.model.Series_;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.*;
import lombok.Builder;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Setter
public class SeriesFilter implements Specification<Series> {
    private String title;
    private String originalTitle;
    private String releaseYear;
    private String country;
    private Boolean isFinished;
    private String mpaaRatingName;
    private String rarsRatingName;
    private Set<String> genres;

    @Override
    public Predicate toPredicate(@NonNull Root<Series> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(title)) {
            predicates.add(criteriaBuilder.like(root.get(Series_.TITLE), "%" + title + "%"));
        }
        if (StringUtils.isNotBlank(originalTitle)) {
            predicates.add(criteriaBuilder.like(root.get(Series_.ORIGINAL_TITLE), "%" + originalTitle + "%"));
        }
        if (StringUtils.isNotBlank(releaseYear)) {
            predicates.add(criteriaBuilder.equal(root.get(Series_.RELEASE_YEAR), releaseYear));
        }
        if (StringUtils.isNotBlank(country)) {
            predicates.add(criteriaBuilder.like(root.get(Series_.COUNTRY), "%" + country + "%"));
        }
        if (isFinished != null) {
            predicates.add(criteriaBuilder.equal(root.get(Series_.IS_FINISHED), isFinished));
        }
        if (StringUtils.isNotBlank(mpaaRatingName)) {
            Join<Series, MPAARating> mpaaRatingJoin = root.join(Series_.MPAA_RATING);
            predicates.add(criteriaBuilder.equal(mpaaRatingJoin.get(MPAARating_.NAME), mpaaRatingName));
        }
        if (StringUtils.isNotBlank(rarsRatingName)) {
            Join<Series, RARSRating> rarsRatingJoin = root.join(Series_.RARS_RATING);
            predicates.add(criteriaBuilder.equal(rarsRatingJoin.get(RARSRating_.NAME), rarsRatingJoin));
        }
        if (genres != null && !genres.isEmpty()) {
            for (String genre : genres) {
                predicates.add(criteriaBuilder.equal(root.join(Series_.GENRES).get(Genre_.NAME), genre));
            }
        }
        return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
