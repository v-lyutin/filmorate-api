--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie_actors-table
--comment create table filmorate.movie_actors
create table filmorate.movie_actors
(
    id           serial primary key,
    person_id    integer      not null,
    movie_id     integer      not null,
    role         varchar(30) not null,
    is_main_role boolean      not null
);
--rollback drop table filmorate.movie_actors;

--changeset v-lyutin:add-filmorate-movie_actors-table-constraints
--comment add constraints to filmorate.movie_actors table
alter table filmorate.movie_actors
    add constraint movie_actors__persons__fk
        foreign key (person_id) references filmorate.persons (id);

alter table filmorate.movie_actors
    add constraint movie_actors__movies__fk
        foreign key (movie_id) references filmorate.movie (id);
--rollback alter table filmorate.movie_actors drop constraint movie_actors__persons__fk;
--rollback alter table filmorate.movie_actors drop constraint movie_actors__movies__fk;

