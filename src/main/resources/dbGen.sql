DROP DATABASE CarEE;

CREATE DATABASE CarEE;
USE CarEE;

CREATE TABLE Users (
                       id INT auto_increment,
                       username VARCHAR(50),
                       email VARCHAR(255),
                       password VARCHAR(50),
                       isAdmin bool,
                       PRIMARY KEY (id)
);

CREATE TABLE aVehicles (
                          id INT auto_increment,
                          name VARCHAR(100),
                          type VARCHAR(100),
                          price FLOAT,
                          description text,
                          imgURL VARCHAR(255),
                          PRIMARY KEY (id)
);

INSERT INTO Users(username, email, password, isAdmin) VALUES ('admin', 'admin@admin.io', 'admin', true);
