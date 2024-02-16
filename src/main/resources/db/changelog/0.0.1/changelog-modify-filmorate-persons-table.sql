--liquibase formatted sql

--changeset v-lyutin:modify-filmorate-persons-table
--comment add country_of_birth and city_of_birth columns
alter table filmorate.persons
add column country_of_birth varchar(50) not null default 'country',
add column city_of_birth varchar(50) not null default 'city'
--rollback alter table persons drop column country_of_birth;
--rollback alter table persons drop column city_of_birth;