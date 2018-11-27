CREATE TABLE user (
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    email VARCHAR(128) UNIQUE NOT NULL,
    login VARCHAR(64) UNIQUE NOT NULL,
    password CHAR(64) NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE car (
    car_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    make VARCHAR(255),
    model VARCHAR(255),
    year SMALLINT,
    description VARCHAR(255),
    PRIMARY KEY(car_id)
);

CREATE TABLE service_item (
    service_item_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    car_id INT UNSIGNED NOT NULL,
    service_date DATETIME,
    location VARCHAR(255),
    service_company VARCHAR(255),
    description VARCHAR(255),
    PRIMARY KEY(service_item_id)
);
