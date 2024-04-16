package com.filmorate.filmorateapi.media.staff.mapper.impl;

import com.filmorate.filmorateapi.common.mapper.JsonNullableMapper;
import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.movie.service.MovieService;
import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.person.service.PersonService;
import com.filmorate.filmorateapi.media.staff.mapper.StaffMapper;
import com.filmorate.filmorateapi.media.staff.model.Staff;
import com.filmorate.filmorateapi.media.staff.model.StaffRole;
import com.filmorate.filmorateapi.media.staff.service.StaffRoleService;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffUpdateRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.MovieStaffPageResponse;
import com.filmorate.filmorateapi.media.staff.web.dto.request.StaffCreationRequest;
import com.filmorate.filmorateapi.media.staff.web.dto.response.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StaffMapperImpl implements StaffMapper {
    private final MovieService movieService;
    private final PersonService personService;
    private final StaffRoleService staffRoleService;
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Staff map(Long movieId, StaffCreationRequest request) {
        Movie movie = movieService.getMovieById(movieId);
        Person person = personService.getPersonById(request.personId());
        StaffRole staffRole = staffRoleService.getStaffRoleByPosition(request.staffRole());
        return Staff.builder()
                .staffRole(staffRole)
                .person(person)
                .movie(movie)
                .build();
    }

    @Override
    public StaffResponse map(Staff staff) {
        return new StaffResponse(
                staff.getId(),
                staff.getMovie().getId(),
                staff.getPerson().getId(),
                staff.getStaffRole().getPosition()
        );
    }

    @Override
    public MovieStaffPageResponse map(Page<Staff> pageableStaff) {
        List<StaffResponse> staffResponses = pageableStaff.getContent().stream()
                .map(this::map)
                .toList();
        return new MovieStaffPageResponse(
                pageableStaff.getTotalPages(),
                pageableStaff.isFirst(),
                pageableStaff.isLast(),
                pageableStaff.getTotalElements(),
                staffResponses
        );
    }

    @Override
    public Staff update(Staff staff, StaffUpdateRequest request) {
        if (request == null) {
            return staff;
        }
        if (jsonNullableMapper.isPresent(request.staffRole())) {
            StaffRole staffRole = staffRoleService.getStaffRoleByPosition(jsonNullableMapper.unwrap(request.staffRole()));
            staff.setStaffRole(staffRole);
        }
        if (jsonNullableMapper.isPresent(request.personId())) {
            Person person = personService.getPersonById(jsonNullableMapper.unwrap(request.personId()));
            staff.setPerson(person);
        }
        return staff;
    }
}
