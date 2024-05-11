--liquibase formatted sql

--changeset v-lyutin:create-filmorate-compilations-table
--comment create table filmorate.compilations
create table filmorate.compilations
(
    id              serial primary key,
    title           varchar(32) not null,
    description     varchar(1000),
    user_profile_id integer     not null
);
--rollback drop table filmorate.compilations;

--changeset v-lyutin:add-filmorate.compilations-table-constraints
--comment add constraints to filmorate.compilations table
alter table filmorate.compilations
    add constraint compilations__user_profiles__fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);
--rollback alter table filmorate.compilations drop constraint compilations__user_profiles__fk;

--changeset v-lyutin:create-filmorate-genre_compilations-table
--comment create table filmorate.genre_compilations
create table filmorate.genre_compilations
(
    compilation_id integer not null,
    genre_id       integer not null
);
--rollback drop table filmorate.genre_compilations;

--changeset v-lyutin:add-genre_compilations-table-constraints
--comment add constraints to genre_compilations
alter table filmorate.genre_compilations
    add constraint genre_compilations__genre_fk
        foreign key (genre_id) references filmorate.genres (id);

alter table filmorate.genre_compilations
    add constraint genre_compilations__compilation_fk
        foreign key (compilation_id) references filmorate.compilations (id) ON DELETE CASCADE;

alter table filmorate.genre_compilations
    add constraint genre_compilations_genres_unique
        unique (compilation_id, genre_id);
--rollback alter table filmorate.genre_compilations drop constraint genre_compilations__genre_fk;
--rollback alter table filmorate.genre_compilations drop constraint genre_compilations__compilation_fk;
--rollback alter table filmorate.genre_compilations drop constraint genre_compilations_genres_unique;

--changeset v-lyutin:create-filmorate-compilation_likes-table
--comment create table filmorate.compilation_likes
create table filmorate.compilation_likes
(
    compilation_id  integer not null,
    user_profile_id integer not null
);
--rollback drop table filmorate.compilation_likes;

--changeset v-lyutin:add-compilation_likes-table-constraints
--comment add constraints to compilation_likes
alter table filmorate.compilation_likes
    add constraint compilation_likes__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.compilation_likes
    add constraint compilation_likes__compilation_fk
        foreign key (compilation_id) references filmorate.compilations (id) ON DELETE CASCADE;

alter table filmorate.compilation_likes
    add constraint compilation_likes_unique
        unique (compilation_id, user_profile_id);
--rollback alter table filmorate.compilation_likes drop constraint compilation_likes;
--rollback alter table filmorate.compilation_likes drop constraint compilation_likes__compilation_fk;
--rollback alter table filmorate.compilation_likes drop constraint compilation_likes_unique;

--changeset v-lyutin:create-filmorate-movie_compilations-table
--comment create table filmorate.movie_compilations
create table filmorate.movie_compilations
(
    movie_id       integer not null,
    compilation_id integer not null
);
--rollback drop table filmorate.movie_compilations;

--changeset v-lyutin:add-movie_compilations-table-constraints
--comment add constraints to movie_compilations
alter table filmorate.movie_compilations
    add constraint movie_compilations__movie_fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.movie_compilations
    add constraint movie_compilations__compilation_fk
        foreign key (compilation_id) references filmorate.compilations (id) ON DELETE CASCADE;

alter table filmorate.movie_compilations
    add constraint movie_compilations__unique
        unique (compilation_id, movie_id);
--rollback alter table filmorate.movie_compilations drop constraint movie_compilations__movie_fk;
--rollback alter table filmorate.movie_compilations drop constraint movie_compilations__compilation_fk;
--rollback alter table filmorate.movie_compilations drop constraint movie_compilations__unique;

--changeset v-lyutin:create-filmorate-series_compilations-table
--comment create table filmorate.series_compilations
create table filmorate.series_compilations
(
    series_id       integer not null,
    compilation_id integer not null
);
--rollback drop table filmorate.series_compilations;

--changeset v-lyutin:add-series_compilations-table-constraints
--comment add constraints to series_compilations
alter table filmorate.series_compilations
    add constraint series_compilations__series_fk
        foreign key (series_id) references filmorate.series (id);

alter table filmorate.series_compilations
    add constraint series_compilations__compilation_fk
        foreign key (compilation_id) references filmorate.compilations (id) ON DELETE CASCADE;

alter table filmorate.series_compilations
    add constraint series_compilations__unique
        unique (compilation_id, series_id);
--rollback alter table filmorate.series_compilations drop constraint series_compilations__series_fk;
--rollback alter table filmorate.series_compilations drop constraint series_compilations__compilation_fk;
--rollback alter table filmorate.series_compilations drop constraint series_compilations__unique;