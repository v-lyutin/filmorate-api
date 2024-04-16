--liquibase formatted sql

--changeset v-lyutin:create-filmorate-movie_staff_roles-table
--comment create table filmorate.movie_staff_roles
create table filmorate.movie_staff_roles
(
    id       serial primary key,
    position varchar(30) not null
);
--rollback drop table filmorate.movie_staff_roles;

--changeset v-lyutin:add-filmorate-movie_staff_roles-table-constraints
--comment add constraints to filmorate.movie_staff_roles table
alter table filmorate.movie_staff_roles
    add constraint movie_staff_roles__position__unique
        unique (position);
--rollback alter table filmorate.movie_staff_roles drop constraint movie_staff_roles__position__unique;

--changeset v-lyutin:create-filmorate-movie_staff-table
--comment create table filmorate.movie_staff
create table filmorate.movie_staff
(
    id            serial primary key,
    person_id     integer not null,
    movie_id      integer not null,
    staff_role_id integer not null
);
--rollback drop table filmorate.movie_staff;

--changeset v-lyutin:add-filmorate-movie_staff-table-constraints
--comment add constraints to filmorate.movie_staff table
alter table filmorate.movie_staff
    add constraint movie_staff__persons__fk
        foreign key (person_id) references filmorate.persons (id);

alter table filmorate.movie_staff
    add constraint movie_staff__movies__fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.movie_staff
    add constraint movie_staff__staff_roles__fk
        foreign key (staff_role_id) references filmorate.movie_staff_roles (id);
--rollback alter table filmorate.movie_staff drop constraint movie_actors__persons__fk;
--rollback alter table filmorate.movie_staff drop constraint movie_actors__movies__fk;
--rollback alter table filmorate.movie_staff drop constraint movie_staff__staff_roles__fk;