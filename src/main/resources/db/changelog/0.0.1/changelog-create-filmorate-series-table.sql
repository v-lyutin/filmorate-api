--liquibase formatted sql

--changeset v-lyutin:create-filmorate-series-table
--comment create table filmorate.movie_staff_roles
create table filmorate.series
(
    id             serial primary key,
    poster_url     varchar       not null,
    title          varchar(32)   not null,
    original_title varchar(32)   not null,
    description    varchar(1000) not null,
    release_year   integer       not null,
    country        varchar(32),
    is_finished    boolean       not null
);
--rollback drop table filmorate.series;

--changeset v-lyutin:create-filmorate-series_genres-table
--comment create table filmorate.series_genres
create table filmorate.series_genres
(
    series_id integer not null,
    genre_id  integer not null
);
--rollback drop table filmorate.series_genres;

--changeset v-lyutin:add-series_genres-table-constraints
--comment add constraints to series_genres
alter table filmorate.series_genres
    add constraint series_genres__genres_fk
        foreign key (genre_id) references filmorate.genres (id);

alter table filmorate.series_genres
    add constraint series_genres__movie_fk
        foreign key (series_id) references filmorate.series (id);

alter table filmorate.series_genres
    add constraint series_genres_unique
        unique (series_id, genre_id);
--rollback alter table filmorate.series_genres drop constraint series_genres__genres_fk;
--rollback alter table filmorate.series_genres drop constraint series_genres__movie_fk;
--rollback alter table filmorate.series_genres drop constraint series_genres_unique;

--changeset v-lyutin:create-filmorate-seasons-table
--comment create table filmorate.seasons
create table filmorate.seasons
(
    id            serial primary key,
    poster_url    varchar not null,
    season_number integer not null,
    series_id     integer not null
);
--rollback drop table filmorate.seasons;

--changeset v-lyutin:add-filmorate-seasons-table-constraints
--comment add constraints to filmorate.seasons table
alter table filmorate.seasons
    add constraint seasons__series__fk
        foreign key (series_id) references filmorate.series (id);
--rollback alter table filmorate.seasons drop constraint seasons__series__fk;

--changeset v-lyutin:create-filmorate-episodes-table
--comment create table filmorate.episodes
create table filmorate.episodes
(
    id             serial primary key,
    preview_url    varchar       not null,
    episode_number integer       not null,
    title          varchar(32)   not null,
    original_title varchar(32)   not null,
    description    varchar(1000) not null,
    duration       integer       not null,
    release_date   date          not null,
    season_id      integer       not null
);
--rollback drop table filmorate.episodes;

--changeset v-lyutin:add-filmorate-episodes-table-constraints
--comment add constraints to filmorate.episodes table
alter table filmorate.episodes
    add constraint episodes__seasons__fk
        foreign key (season_id) references filmorate.seasons (id);
--rollback alter table filmorate.episodes drop constraint episodes__movies__fk;