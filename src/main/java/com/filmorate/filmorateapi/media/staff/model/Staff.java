package com.filmorate.filmorateapi.media.staff.model;

import com.filmorate.filmorateapi.media.movie.model.Movie;
import com.filmorate.filmorateapi.media.person.model.Person;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "filmorate", name = "movie_staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private StaffRole staffRole;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Movie movie;
}
