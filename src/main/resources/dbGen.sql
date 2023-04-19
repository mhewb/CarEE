DROP DATABASE CarEE;

CREATE DATABASE CarEE;
USE CarEE;

CREATE TABLE Users (
       id INT auto_increment,
       username VARCHAR(50),
       email VARCHAR(255),
       password VARCHAR(50),
#        isAdmin bool,
       PRIMARY KEY (id)
);

CREATE TABLE Categories (
        id INT auto_increment,
        name VARCHAR(100),
        PRIMARY KEY (id)
);

CREATE TABLE Vehicles (
                          id INT auto_increment,
                          name VARCHAR(100),
                          id_category INT,
                          price FLOAT,
                          description text,
                          imgURL VARCHAR(255),

                          PRIMARY KEY (id),
                          FOREIGN KEY (id_category) REFERENCES caree.categories(id)
);

INSERT INTO Users(username, email, password) VALUES ('admin', 'admin@admin.io', 'admin');
INSERT INTO Categories(name) VALUES ('Electrique');
INSERT INTO Vehicles(name, price, description, imgURL, id_category) VALUES
    ('Polestar 2',
     70000.5,
     'Voiture électrique perfectionnée disponible en versions standard et longue autonomie.
Cette bicorps entièrement électrique redéfinit le design et les performances.',
     'https://www.sauvageboris.fr/training/javaee/carEE/resources/cars/car_polestar_2.jpg', 1)