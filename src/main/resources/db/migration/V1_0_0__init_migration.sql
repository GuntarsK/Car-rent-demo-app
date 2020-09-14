CREATE TABLE IF NOT EXISTS customer (
    customer_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(100) NOT NULL,
    password_hash VARCHAR(250) NOT NULL,
    status VARCHAR(10) DEFAULT 'ACTIVE'
);

INSERT INTO customer (first_name, last_name, email, phone_number, address, password_hash) VALUES
('John', 'Doe', 'john.doe@mail.com', '+371 20003000', '45 E. Ivy St. Tallahassee, FL 32303', '00000'),
('Jane', 'Smith', 'jane.smith@mail.com', '+371 50001000', '8 Atlantic St. Wheeling, WV 26003', '00000'),
('David', 'Jones', 'david.jones@mail.com', '+371 40002000', '9 Cactus Ave. Saint Louis, MO 63109', '00000'),
('Mike', 'Carlos', 'mike.carlos@mail.com', '+371 60008000', '9313 Grandrose Road Griffin, GA 30223', '00000'),
('Bod', 'Smith', 'bob.smith@mail.com','+371 90004000', '8124 Roehampton Lane Conway, SC 29526', '00000');
