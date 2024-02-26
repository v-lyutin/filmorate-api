--changeset v-lyutin:create-filmorate-favorite_persons-table
--comment create table filmorate.favorite_persons
create table filmorate.favorite_persons
(
    user_profile_id integer not null,
    person_id    integer not null
);
--rollback drop table filmorate.favorite_persons;

--changeset v-lyutin:add-favorite_persons-table-constraints
--comment add constraints to favorite_persons
alter table filmorate.favorite_persons
    add constraint favorite_persons__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.favorite_persons
    add constraint favorite_persons__person_fk
        foreign key (person_id) references filmorate.persons (id);

alter table filmorate.favorite_persons
    add constraint favorite_persons_unique
        unique (user_profile_id, person_id);
--rollback alter table filmorate.favorite_persons drop constraint favorite_persons__user_profile_fk;
--rollback alter table filmorate.favorite_persons drop constraint favorite_persons__person_fk;
--rollback alter table filmorate.favorite_persons drop constraint favorite_persons_unique;
