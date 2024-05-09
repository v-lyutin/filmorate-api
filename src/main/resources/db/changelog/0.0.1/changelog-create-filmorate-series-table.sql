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

--changeset v-lyutin:create-filmorate-series_likes-table
--comment create table filmorate.series_likes
create table filmorate.series_likes
(
    series_id integer not null,
    user_profile_id integer not null
);
--rollback drop table filmorate.series_likes;

--changeset v-lyutin:add-series_likes-table-constraints
--comment add constraints to series_likes
alter table filmorate.series_likes
    add constraint series_likes__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.series_likes
    add constraint series_likes__series_fk
        foreign key (series_id) references filmorate.series (id);

alter table filmorate.series_likes
    add constraint series_likes_unique
        unique (series_id, user_profile_id);
--rollback alter table filmorate.series_likes drop constraint series_likes__user_profile_fk;
--rollback alter table filmorate.series_likes drop constraint series_likes__series_fk;
--rollback alter table filmorate.series_likes drop constraint series_likes_unique;

--changeset v-lyutin:create-filmorate-series_content-table
--comment create table filmorate.series_content
create table filmorate.series_content
(
    id           serial primary key,
    content_type varchar not null,
    title        varchar(50),
    content_url  varchar not null,
    series_id    integer not null
);
--rollback drop table filmorate.series_content;

--changeset v-lyutin:add-filmorate-series_content-table-constraints
--comment add constraints to filmorate.series_content table
alter table filmorate.series_content
    add constraint series_content__series__fk
        foreign key (series_id) references filmorate.series (id);
--rollback alter table filmorate.series_content drop constraint series_content__series__fk;

--changeset v-lyutin:create-filmorate-episodes_content-table
--comment create table filmorate.episodes_content
create table filmorate.episodes_content
(
    id           serial primary key,
    content_type varchar not null,
    title        varchar(50),
    content_url  varchar not null,
    episode_id    integer not null
);
--rollback drop table filmorate.episodes_content;

--changeset v-lyutin:add-filmorate-episodes_content-table-constraints
--comment add constraints to filmorate.episodes_content table
alter table filmorate.episodes_content
    add constraint episodes_content__episodes__fk
        foreign key (episode_id) references filmorate.episodes (id);
--rollback alter table filmorate.episodes_content drop constraint episodes_content__episodes__fk;

--changeset v-lyutin:create-filmorate-series_actors-table
--comment create table filmorate.series_actors
create table filmorate.series_actors
(
    id           serial primary key,
    person_id    integer      not null,
    series_id     integer      not null,
    role         varchar(32) not null,
    is_main_role boolean      not null
);
--rollback drop table filmorate.series_actors;

--changeset v-lyutin:add-filmorate-series_actors-table-constraints
--comment add constraints to filmorate.series_actors table
alter table filmorate.series_actors
    add constraint series_actors__persons__fk
        foreign key (person_id) references filmorate.persons (id);

alter table filmorate.series_actors
    add constraint series_actors__series__fk
        foreign key (series_id) references filmorate.series (id);
--rollback alter table filmorate.series_actors drop constraint series_actors__persons__fk;
--rollback alter table filmorate.series_actors drop constraint series_actors__series__fk;