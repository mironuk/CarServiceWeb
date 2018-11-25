create table user (
    user_id bigint not null auto_increment,
    email varchar(128),
    login varchar(64) unique not null,
    pass char(64) not null,
    primary key(user_id)
) engine = InnoDB default charset = utf8;

create table car (
    car_id bigint not null auto_increment,
    user_id bigint not null,
    make varchar(255),
    model varchar(255),
    year smallint,
    description varchar(255),
    primary key(car_id)
) engine = InnoDB default charset = utf8;

create table service_item (
    service_item_id bigint not null auto_increment,
    car_id bigint not null,
    service_date datetime,
    location varchar(255),
    service_company varchar(255),
    description varchar(255),
    primary key(service_item_id)
) engine = InnoDB default charset = utf8;
