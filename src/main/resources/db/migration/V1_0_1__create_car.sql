CREATE TABLE IF NOT EXISTS car (
    car_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_body_type VARCHAR(20) NOT NULL,
    year_of_production INTEGER NOT NULL,
    mileage INTEGER NOT NULL,
    amount DOUBLE NOT NULL,
    status VARCHAR(15) NOT NULL,
    status_in_db VARCHAR(15) DEFAULT 'ACTIVE'
);


INSERT INTO car (make, model, car_body_type, year_of_production, mileage, amount, status) VALUES
('VW', 'Passat', 'SEDAN', 2017, 87012, 60.00, 'RENTED'),
('Audi', 'A4', 'SEDAN', 2019, 46050, 100.00, 'RENTED'),
('Renault', 'Trafic', 'VAN', 2016, 145029, 58.00, 'RENTED'),
('BMW', 'X3', 'SUV', 2018, 116023, 73.00, 'RENTED'),
('KIA', 'Sportage', 'SUV', 2017, 128312, 47.00, 'RENTED'),
('BMW', '320', 'SEDAN', 2019, 33054, 95.00, 'AVAILABLE'),
('Audi', 'A6', 'SEDAN', 2016, 58312, 88.00, 'AVAILABLE'),
('Volvo', 'XC90', 'SUV', 2018, 60312, 109.00, 'AVAILABLE'),
('Volvo', 'XC60', 'SUV', 2019, 25312, 94.00, 'AVAILABLE');


