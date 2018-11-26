CREATE TABLE user (
    user_id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(128),
    login VARCHAR(64) UNIQUE NOT NULL,
    pass CHAR(64) NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE car (
    car_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    make VARCHAR(255),
    model VARCHAR(255),
    year SMALLINT,
    description VARCHAR(255),
    PRIMARY KEY(car_id)
);

CREATE TABLE service_item (
    service_item_id BIGINT NOT NULL AUTO_INCREMENT,
    car_id bigint NOT NULL,
    service_date DATETIME,
    location VARCHAR(255),
    service_company VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY(service_item_id)
);
