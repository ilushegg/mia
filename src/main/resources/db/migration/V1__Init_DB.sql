create table message(
    id bigint not null,
    text varchar(1024) not null,
    tag varchar(255) not null,
    filename varchar(255) not null,
    user_id bigint,
    primary key(id)
) engine InnoDB;

create table user(
    id bigint not null,
    username varchar(255) not null,
    password varchar(255) not null,
    active bit not null,
    primary key(id)
) engine InnoDB;