--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie_content-table
--comment create table filmorate.movie_content
create table filmorate.movie_content
(
    id           serial primary key,
    content_type varchar not null,
    title        varchar(50),
    content_url  varchar not null,
    movie_id     integer not null
);
--rollback drop table filmorate.movie_content;

--changeset v-lyutin:add-filmorate-movie-table-constraints
--comment add constraints to filmorate.movie table
alter table filmorate.movie_content
    add constraint movie_content__movie__fk
        foreign key (movie_id) references filmorate.movie (id);
--rollback alter table filmorate.movie_content drop constraint movie_content__movie__fk;

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