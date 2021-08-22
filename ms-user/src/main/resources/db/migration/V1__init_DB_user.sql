create table users
(
    id       bigserial PRIMARY KEY,
    username varchar(50) not null,
    password varchar(30) not null,
    email    varchar(50) not null
);

create table roles
(
    id   serial PRIMARY KEY,
    name varchar(50) not null
);

insert into roles(name)
values ('ROLE_ADMIN'),
       ('ROLE_USER');

create table users_roles
(
    user_id bigserial not null,
    role_id bigserial not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table address
(
    id           bigserial PRIMARY KEY,
    postcode     integer     not null,
    country      varchar(80) not null,
    city         varchar(80) not null,
    street       varchar(80) not null,
    house_number integer     not null
);

create table users_address
(
    user_id    bigserial not null,
    address_id bigserial not null,
    primary key (user_id, address_id),
    foreign key (user_id) references users (id),
    foreign key (address_id) references address (id)
);

