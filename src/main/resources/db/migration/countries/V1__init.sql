create extension if not exists "uuid-ossp";

create table if not exists countries
(
    id UUID not null default uuid_generate_v1() primary key,
    code varchar(2) unique not null,
    name varchar(50) not null,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);