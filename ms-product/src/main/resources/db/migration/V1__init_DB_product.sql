create table products
(
    id           bigserial PRIMARY KEY,
    title        varchar(255) not null,
    cost         double precision,
    availability boolean,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

create table categories
(
    id       bigserial PRIMARY KEY,
    category varchar(255) not null
);

create table products_categories
(
    product_id  bigserial not null,
    category_id bigserial not null,
    primary key (product_id, category_id),
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);