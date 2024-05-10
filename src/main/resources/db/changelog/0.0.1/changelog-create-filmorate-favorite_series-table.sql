--changeset v-lyutin:create-filmorate-favorite_series-table
--comment create table filmorate.favorite_series
create table filmorate.favorite_series
(
    user_profile_id integer not null,
    series_id       integer not null
);
--rollback drop table filmorate.favorite_series;

--changeset v-lyutin:add-favorite_series-table-constraints
--comment add constraints to favorite_series
alter table filmorate.favorite_series
    add constraint favorite_series__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.favorite_series
    add constraint favorite_series__series_fk
        foreign key (series_id) references filmorate.series (id);

alter table filmorate.favorite_series
    add constraint favorite_series__unique
        unique (user_profile_id, series_id);
--rollback alter table filmorate.favorite_series drop constraint favorite_series__user_profile_fk;
--rollback alter table filmorate.favorite_series drop constraint favorite_series__series_fk;
--rollback alter table filmorate.favorite_series drop constraint favorite_series__unique;