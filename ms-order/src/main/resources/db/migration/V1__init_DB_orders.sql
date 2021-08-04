create table orders
(
    id              bigserial PRIMARY KEY,
    cost            double precision,
    address         varchar(255) not null,
    payment_status  boolean,
    delivery_status varchar(50)
);

create table items
(
    id             bigserial PRIMARY KEY,
    price_per_unit double precision,
    price          double precision,
    quantity       integer
);

create table orders_items
(
    order_id bigserial not null,
    item_id  bigserial not null,
    primary key (order_id, item_id),
    foreign key (order_id) references orders (id),
    foreign key (item_id) references items (id)
);