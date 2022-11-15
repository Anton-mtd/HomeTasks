INSERT INTO products (title, price)
VALUES ('Bread', 50),
       ('Milk', 80),
       ('Orange', 100),
       ('Cheese', 250),
       ('Tea', 50),
       ('Spaghetti', 70),
       ('Chips', 100),
       ('Juice', 120),
       ('Gum', 30),
       ('Pepsi', 100),
       ('Fanta', 90),
       ('Tomato', 150),
       ('Cucumber', 80),
       ('Chocolate', 60),
       ('Cookie', 70),
       ('Sprite', 90),
       ('Coffee', 200),
       ('Chicken', 220),
       ('Pork', 250),
       ('Beef', 300),
       ('Apple', 60),
       ('PineApple', 250),
       ('Mandarin', 120),
       ('Olives', 120),
       ('Potato', 40)
;

INSERT INTO customers (name)
VALUES ('Mike'),
       ('John'),
       ('Nick'),
       ('Nicol'),
       ('Natali')
;

INSERT INTO customers_products (customer_id, product_id)
VALUES (1, 1),
       (1, 4),
       (1, 6),
       (1, 16),
       (1, 17),
       (1, 7),
       (2, 4),
       (2, 16),
       (2, 7),
       (2, 13),
       (2, 15),
       (2, 8),
       (3, 1),
       (3, 21),
       (3, 4),
       (3, 17),
       (3, 24),
       (3, 6),
       (4, 1),
       (4, 10),
       (4, 19),
       (4, 15),
       (4, 12),
       (4, 9),
       (4, 22)
       ;

INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_MANAGER'),
       ('ROLE_CLIENT');

INSERT INTO users (login, password, role_id)
VALUES ('userAdmin', 'admin', 1),
       ('userManager', 'manager', 2),
       ('userClient', 'client', 3)
;






