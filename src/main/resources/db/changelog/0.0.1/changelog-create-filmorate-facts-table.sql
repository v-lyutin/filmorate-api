--liquibase formatted sql

--changeset v-lyutin:create-filmorate-facts-table
--comment create table filmorate.table
create table filmorate.facts
(
    id         serial primary key,
    text       varchar(300) not null,
    person_id  integer      not null,
    created_at timestamp    not null,
    created_by varchar(50)  not null
);
--rollback drop table filmorate.facts;

--changeset v-lyutin:add-filmorate-facts-table-constraints
--comment add constraints to filmorate.facts table
alter table filmorate.facts
    add constraint facts__persons__fk
        foreign key (person_id) references filmorate.persons (id);
--rollback alter table filmorate.facts drop constraint facts__persons__fk;

--changeset v-lyutin:add-filmorate-facts-table-columns-edited_at-edited_by
--comment add columns edited_at and edited_by to filmorate.facts table
alter table filmorate.facts
    add column edited_at timestamp,
    add column edited_by varchar(50);

update filmorate.facts
set edited_at = created_at
where edited_at is null;

update filmorate.facts
set edited_by = created_by
where edited_by is null;

alter table filmorate.facts
    alter column edited_at set not null;

alter table filmorate.facts
    alter column edited_by set not null;
--rollback alter table filmorate.facts drop column edited_at;
--rollback alter table filmorate.facts drop column edited_by;