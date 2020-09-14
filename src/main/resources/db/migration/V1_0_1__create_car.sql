CREATE TABLE IF NOT EXISTS car (
    car_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_body_type VARCHAR(20) NOT NULL,
    year_of_production INTEGER NOT NULL,
    mileage INTEGER NOT NULL,
    amount DOUBLE NOT NULL,
    status VARCHAR(15) DEFAULT 'AVAILABLE',
    status_in_db VARCHAR(10) DEFAULT 'ACTIVE'
);


INSERT INTO car (make, model, car_body_type, year_of_production, mileage, amount) VALUES
('VW', 'Passat', 'SEDAN', 2017, 87012, 60.00),
('Audi', 'A4', 'SEDAN', 2019, 46050, 100.00),
('Renault', 'Trafic', 'VAN', 2016, 145029, 58.00),
('BMW', 'X3', 'SUV', 2018, 116023, 73.00),
('KIA', 'Sportage', 'SUV', 2017, 128312, 47.00);

