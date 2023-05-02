create database kp1;

USE kp1;

CREATE TABLE employees (
                           id int NOT NULL AUTO_INCREMENT,
                           name varchar(15),
                           surname varchar(25),
                           login varchar(20),
                           pass varchar(20),
                           PRIMARY KEY (id)
) ;

INSERT INTO kp1.employees (name, surname, login, pass)
VALUES
    ('Alex', 'Sond', 'Alex_So', '1234'),
    ('Oleg', 'Ivanov', 'oleg123', '4321'),
    ('Ivan', 'Antalion', 'Antal2', 'qwert');


