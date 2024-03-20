--liquibase formatted sql

--changeset v-lyutin:create-filmorate-persons-table
--comment create table filmorate.persons
create table filmorate.persons
(
    id         serial primary key,
    first_name varchar(32) not null,
    last_name  varchar(32) not null,
    birth_date date        not null,
    height     integer     not null,
    image_link varchar
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

--changeset v-lyutin:drop-filmorate-persons-columns-first_name-last_name
--comment drop filmorate.persons columns first_name, last_name
alter table filmorate.persons
    drop column first_name,
    drop column last_name,
    add column name varchar(32) not null;
--rollback alter table filmorate.persons add first_name;
--rollback alter table filmorate.persons add column last_name;
--rollback alter table filmorate.persons drop column name;
