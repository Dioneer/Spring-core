--changeset bilbo:1
create table if not exists company(
id serial primary key,
name_company varchar(64) not null unique
);
--changeset bilbo:2
create table if not exists company_loclas(
company_id int references company(id),
lang varchar(2),
description varchar(255) not null,
primary key (company_id, lang)
);
--changeset bilbo:3
create table if not exists users(
    id bigserial primary key,
    username varchar(64) not null unique,
    birthday_date date,
    firstname varchar(64),
    lastname varchar(64),
    role varchar(32),
    company_id int references company(id),
    image varchar(128),
    password varchar(128) default '{noop}123'
);
--changeset bilbo:4
create table if not exists chat(
    id bigserial primary key,
    chat_name varchar(128) not null
);
--changeset bilbo:5
create table if not exists users_chat(
id bigserial primary key,
user_id bigint not null references users(id),
chat_id bigint not null references chat(id),
unique (user_id, chat_id)
);
--changeset bilbo:6
create table if not exists payment(
    id bigserial primary key,
    amount int not null,
    receiver_id bigint not null references users(id)
);