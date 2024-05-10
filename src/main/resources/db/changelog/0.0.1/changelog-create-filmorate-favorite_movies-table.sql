--changeset v-lyutin:create-filmorate-favorite_movies-table
--comment create table filmorate.favorite_movies
create table filmorate.favorite_movies
(
    user_profile_id integer not null,
    movie_id        integer not null
);
--rollback drop table filmorate.favorite_movies;

--changeset v-lyutin:add-favorite_movies-table-constraints
--comment add constraints to favorite_movies
alter table filmorate.favorite_movies
    add constraint favorite_movies__user_profile_fk
        foreign key (user_profile_id) references filmorate.user_profiles (id);

alter table filmorate.favorite_movies
    add constraint favorite_movies__movie_fk
        foreign key (movie_id) references filmorate.movie (id);

alter table filmorate.favorite_movies
    add constraint favorite_movies_unique
        unique (user_profile_id, movie_id);
--rollback alter table filmorate.favorite_movies drop constraint favorite_movies_unique;
--rollback alter table filmorate.favorite_movies drop constraint favorite_movies__user_profile_fk;
--rollback alter table filmorate.favorite_movies drop constraint favorite_movies__movie_fk;