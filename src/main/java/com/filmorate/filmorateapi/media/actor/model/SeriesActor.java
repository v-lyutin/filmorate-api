package com.filmorate.filmorateapi.media.actor.model;

import com.filmorate.filmorateapi.media.person.model.Person;
import com.filmorate.filmorateapi.media.series.model.Series;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "filmorate", name = "series_actors")
public class SeriesActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Boolean isMainRole;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Series series;
}
