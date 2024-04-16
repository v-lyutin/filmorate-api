--liquibase formatted sql

--changeset v-lyutin:create-filmorate-persons-table
--comment create table filmorate.persons
create table filmorate.persons
(
    id               serial primary key,
    image_link       varchar,
    name             varchar(32),
    birth_date       date,
    country_of_birth varchar(50),
    city_of_birth    varchar(50),
    height           integer,
    event_type       varchar
);
--rollback drop table filmorate.persons;

--changeset v-lyutin:create-filmorate-persons_careers-table
--comment create table filmorate.persons_careers
create table filmorate.persons_careers
(
    person_id integer not null,
    career_id integer not null
);
--rollback drop table filmorate.persons_careers;

--changeset v-lyutin:add-persons_careers-table-constraints
--comment add constraints to persons_careers
alter table filmorate.persons_careers
    add constraint persons_careers__careers_fk
        foreign key (career_id) references filmorate.careers (id);

alter table filmorate.persons_careers
    add constraint persons_careers__persons_fk
        foreign key (person_id) references filmorate.persons (id);

alter table filmorate.persons_careers
    add constraint persons_careers_unique
        unique (person_id, career_id);
--rollback alter table filmorate.persons_careers drop constraint persons_careers__careers_fk;
--rollback alter table filmorate.persons_careers drop constraint persons_careers__persons_fk;
--rollback alter table filmorate.persons_careers drop constraint persons_careers_unique;

--changeset v-lyutin:drop-event_type-column
--comment drop event_type column
alter table filmorate.persons
    drop column event_type;
