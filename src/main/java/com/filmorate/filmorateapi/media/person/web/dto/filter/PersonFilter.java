package com.filmorate.filmorateapi.media.person.web.dto.filter;

import com.filmorate.filmorateapi.media.career.model.Career_;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.model.Person_;
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
public class PersonFilter implements Specification<Person> {
    private String name;
    private String enName;
    private String countryOfBirth;
    private String cityOfBirth;
    private String height;
    private Set<String> careers;

    @Override
    public Predicate toPredicate(@NonNull Root<Person> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(name)) {
            predicates.add(criteriaBuilder.like(root.get(Person_.NAME), "%" + name + "%"));
        }
        if (StringUtils.isNotBlank(enName)) {
            predicates.add(criteriaBuilder.like(root.get(Person_.EN_NAME), "%" + enName + "%"));
        }
        if (StringUtils.isNotBlank(countryOfBirth)) {
            predicates.add(criteriaBuilder.like(root.get(Person_.COUNTRY_OF_BIRTH), "%" + countryOfBirth + "%"));
        }
        if (StringUtils.isNotBlank(cityOfBirth)) {
            predicates.add(criteriaBuilder.like(root.get(Person_.CITY_OF_BIRTH), "%" + cityOfBirth + "%"));
        }
        if (StringUtils.isNotBlank(height)) {
            predicates.add(criteriaBuilder.equal(root.get(Person_.HEIGHT), height));
        }
        if (careers != null && !careers.isEmpty()) {
            for (String career : careers) {
                predicates.add(criteriaBuilder.equal(root.join(Person_.CAREERS).get(Career_.NAME), career));
            }
        }
        return predicates.size() == 0 ? null : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
