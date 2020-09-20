CREATE TABLE IF NOT EXISTS booking (
    booking_pk BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_of_booking TIMESTAMP NOT NULL,
    customer_pk BIGINT NOT NULL,
    car_pk BIGINT NOT NULL,
    date_from TIMESTAMP NOT NULL,
    date_to TIMESTAMP NOT NULL,
    amount DOUBLE,
    status_in_db VARCHAR(10) DEFAULT 'ACTIVE',
    CONSTRAINT fk_booking_customer FOREIGN KEY (customer_pk) REFERENCES customer (customer_pk),
    CONSTRAINT fk_booking_car FOREIGN KEY (car_pk) REFERENCES car (car_pk)

);

INSERT INTO booking (date_of_booking, customer_pk, car_pk, date_from, date_to, amount) VALUES
('2020-08-25', 3, 1, '2020-08-27', '2020-08-28', 60.00),
('2020-08-25', 2, 2, '2020-09-01', '2020-09-03', 200.00),
('2020-08-22', 1, 3, '2020-08-25', '2020-08-29', 232.00),
('2020-08-21', 5, 4, '2020-08-26', '2020-08-28', 146.00),
('2020-08-21', 4, 5, '2020-08-26', '2020-08-28', 94.00);
