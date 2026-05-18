 DROP DATABASE IF EXISTS stockdb;
CREATE DATABASE stockdb;
USE stockdb;

CREATE TABLE stock (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    symbol VARCHAR(255),
    quantity INT,
    purchase_price DOUBLE
);

CREATE TABLE portfolio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    stock_id BIGINT
);

DESCRIBE stock;

INSERT INTO stock (name, symbol, quantity, purchase_price)
VALUES ('TCS', 'TCS', 10, 3500);

INSERT INTO stock (name, symbol, quantity, purchase_price)
VALUES ('Infosys', 'INFY', 5, 1500);

INSERT INTO stock (name, symbol, quantity, purchase_price)
VALUES ('Reliance', 'RELIANCE', 8, 2500);

SELECT * FROM stock;

INSERT INTO portfolio (user_id, stock_id) VALUES (1, 1);
INSERT INTO portfolio (user_id, stock_id) VALUES (1, 2);
INSERT INTO portfolio (user_id, stock_id) VALUES (1, 3);

SELECT * FROM portfolio;