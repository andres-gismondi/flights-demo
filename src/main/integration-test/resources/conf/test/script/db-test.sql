CREATE TABLE IF NOT EXISTS `flight_ticket` (
         `id` INT(11) NOT NULL AUTO_INCREMENT,
         `departure_date` DATE NOT NULL,
         `arrival_date` DATE NOT NULL,
         `city_of_origin` VARCHAR(45) NOT NULL,
         `destination_city`  VARCHAR(45) NOT NULL,
         `passenger_name`  VARCHAR(45) NOT NULL,
         `has_luggage_storage` TINYINT(1) NOT NULL,
         `price` DECIMAL(19,2) NOT NULL,
         `departure_time` TIME NOT NULL,
         `arrival_time` TIME NOT NULL,
         `itinerary_id` VARCHAR(45) NOT NULL,
         PRIMARY KEY (`id`)
);

INSERT INTO `flight_ticket` (id, departure_date, arrival_date, city_of_origin, destination_city, passenger_name,
                             has_luggage_storage, price, departure_time, arrival_time, itinerary_id) VALUES
(1, '2020-12-01', '2020-12-02', 'Miami', 'Barcelona', 'Andres', 1, 2550, '08:00:00','10:00:00', 'frgt-345t-o9i8-frg56'),
(2, '2020-09-23', '2020-09-23', 'London', 'Los Angeles', 'Josephine', 0, 1500, '08:00:00','23:25:00', 'frgt-defg-o9i8-3fdws'),
(3, '2020-11-07', '2020-11-08', 'Caracas', 'New York', 'Mariana', 0, 600, '08:00:00','13:15:00', 'acsf-345t-45te-frg56'),
(4, '2020-10-11', '2020-10-11', 'Buenos Aires', 'Berlin', 'Jhon', 1, 1234, '05:00:00','20:00:00', 't56y-456f-wef4-vgh8');
