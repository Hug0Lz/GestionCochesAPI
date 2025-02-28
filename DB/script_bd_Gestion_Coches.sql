DROP DATABASE IF EXISTS GestionCoches;
CREATE DATABASE GestionCoches;
USE GestionCoches;

CREATE TABLE brands (
  id_brands BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE,
  country VARCHAR(255)
);

CREATE TABLE services (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL UNIQUE,
  description TEXT,
  price DECIMAL(10, 2)
);

CREATE TABLE car_models (
  id_car_models BIGINT AUTO_INCREMENT PRIMARY KEY,
  model VARCHAR(255) NOT NULL,
  generation VARCHAR(255),
  `year` INT NOT NULL,
  segment ENUM('A', 'B', 'C', 'D', 'E', 'F', 'J', 'M', 'S'),
  price DECIMAL(10, 2),
  brand_id BIGINT,
  FOREIGN KEY (brand_id) REFERENCES brands(id_brands)
);

CREATE TABLE car_engine (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  fuel_type VARCHAR(255),
  drivetrain VARCHAR(255),
  engine_code VARCHAR(255),
  engine_hp SMALLINT,
  engine_torque SMALLINT,
  engine_displacement SMALLINT,
  cylinder_number TINYINT,
  injection_system VARCHAR(255),
  engine_aspiration VARCHAR(255),
  maximum_speed SMALLINT,
  acceleration DOUBLE
);

CREATE TABLE car_details (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  vin VARCHAR(17) NOT NULL UNIQUE,
  color VARCHAR(255),
  extras TEXT,
  car_model_id BIGINT,
  engine_id BIGINT,  -- Nueva clave foránea para car_engine
  FOREIGN KEY (car_model_id) REFERENCES car_models(id_car_models),
  FOREIGN KEY (engine_id) REFERENCES car_engine(id)
);

CREATE TABLE car_service (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  car_detail_id BIGINT,
  service_id BIGINT,
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (car_detail_id) REFERENCES car_details(id),
  FOREIGN KEY (service_id) REFERENCES services(id),
  UNIQUE (car_detail_id, service_id)  -- Asegura que un coche no tenga el mismo servicio más de una vez
);

CREATE TABLE license_plates (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  plate_number VARCHAR(255) NOT NULL UNIQUE,
  car_id BIGINT,
  state TEXT,
  FOREIGN KEY (car_id) REFERENCES car_details(id)
);

INSERT INTO brands (name, country) VALUES 
('Aston Martin', 'Reino Unido'),
('Audi', 'Alemania'),
('Bentley', 'Reino Unido'),
('BMW', 'Alemania'),
('Bugatti', 'Francia'),
('Citroën', 'Francia'),
('Dacia', 'Rumanía'),
('Ferrari', 'Italia'),
('Fiat', 'Italia'),
('Ford', 'Estados Unidos'),
('Honda', 'Japón'),
('Hyundai', 'Corea del Sur'),
('Jaguar', 'Reino Unido'),
('Kia', 'Corea del Sur'),
('Lamborghini', 'Italia'),
('Land Rover', 'Reino Unido'),
('Lexus', 'Japón'),
('Mazda', 'Japón'),
('McLaren', 'Reino Unido'),
('Mercedes-Benz', 'Alemania'),
('Mini', 'Reino Unido'),
('Mitsubishi', 'Japón'),
('Nissan', 'Japón'),
('Peugeot', 'Francia'),
('Porsche', 'Alemania'),
('Renault', 'Francia'),
('Rolls-Royce', 'Reino Unido'),
('SEAT', 'España'),
('Škoda', 'República Checa'),
('Subaru', 'Japón'),
('Suzuki', 'Japón'),
('Tesla', 'Estados Unidos'),
('Toyota', 'Japón'),
('Volkswagen', 'Alemania'),
('Volvo', 'Suecia');


INSERT INTO car_models (model, generation, `year`, segment, price, brand_id) VALUES 
('A4', 'B9', 2023, 'D', 45000.00, (SELECT id_brands FROM brands WHERE name='Audi')),
('Civic', '10th', 2022, 'C', 25000.00, (SELECT id_brands FROM brands WHERE name='Honda')),
('Model 3', '1st', 2023, 'D', 55000.00, (SELECT id_brands FROM brands WHERE name='Tesla')),
('Corolla', '12th', 2023, 'C', 23000.00, (SELECT id_brands FROM brands WHERE name='Toyota')),
('Golf', '8th', 2023, 'C', 27000.00, (SELECT id_brands FROM brands WHERE name='Volkswagen')),
('3 Series', 'G20', 2023, 'D', 48000.00, (SELECT id_brands FROM brands WHERE name='BMW')),
('Qashqai', '3rd', 2023, 'C', 32000.00, (SELECT id_brands FROM brands WHERE name='Nissan')),
('508', '2nd', 2023, 'D', 35000.00, (SELECT id_brands FROM brands WHERE name='Peugeot')),
('Clio', '5th', 2023, 'B', 19000.00, (SELECT id_brands FROM brands WHERE name='Renault')),
('Tucson', '4th', 2023, 'C', 31000.00, (SELECT id_brands FROM brands WHERE name='Hyundai')),
('Panda', '3rd', 2023, 'A', 15000.00, (SELECT id_brands FROM brands WHERE name='Fiat')),
('XC60', '2nd', 2023, 'D', 53000.00, (SELECT id_brands FROM brands WHERE name='Volvo')),
('F-Pace', '1st', 2023, 'D', 60000.00, (SELECT id_brands FROM brands WHERE name='Jaguar')),
('Defender', '2nd', 2023, 'J', 70000.00, (SELECT id_brands FROM brands WHERE name='Land Rover'));




INSERT INTO car_engine (fuel_type, drivetrain, engine_code, engine_hp, engine_torque, engine_displacement, cylinder_number, injection_system, engine_aspiration, maximum_speed, acceleration) VALUES 
('Gasolina', 'FWD', 'DLZ-45', 150, 200, 2000, 4, 'Direct Injection', 'Turbo', 210, 8.5),
('Gasolina', 'FWD', 'L15B7', 158, 187, 1498, 4, 'Direct Injection', 'Turbo', 205, 7.7),
('Eléctrico', 'AWD', 'TES-123', 283, 307, 0, 0, 'Electric', 'N/A', 225, 5.3),
('Gasolina', 'FWD', '2ZR-FE', 132, 128, 1798, 4, 'Sequential Multiport Fuel Injection', 'Naturally Aspirated', 195, 9.0),
('Gasolina', 'FWD', 'CHH-098', 170, 250, 2000, 4, 'Direct Injection', 'Turbo', 220, 7.4),
('Gasolina', 'RWD', 'B48B20', 255, 295, 1998, 4, 'Direct Injection', 'Turbo', 240, 5.8),
('Gasolina', 'FWD', 'MR20DD', 140, 200, 1997, 4, 'Direct Injection', 'Turbo', 200, 9.2),
('Gasolina', 'FWD', 'EB2ADTS', 180, 250, 1598, 4, 'Direct Injection', 'Turbo', 220, 7.9),
('Gasolina', 'FWD', 'H4D', 90, 160, 999, 3, 'Multi-Point Injection', 'Turbo', 185, 11.6),
('Gasolina', 'AWD', 'G4NL', 175, 195, 1591, 4, 'Direct Injection', 'Turbo', 210, 8.1),
('Gasolina', 'FWD', '169A4000', 69, 102, 1242, 4, 'Multi-Point Injection', 'Naturally Aspirated', 160, 14.2),
('Gasolina', 'AWD', 'B4204T48', 250, 350, 1969, 4, 'Direct Injection', 'Turbo', 230, 6.5),
('Gasolina', 'AWD', 'AJ200D', 250, 365, 1999, 4, 'Direct Injection', 'Turbo', 240, 6.8),
('Diésel', 'AWD', 'P300', 300, 650, 2996, 6, 'Direct Injection', 'Turbo', 190, 8.5);

INSERT INTO car_details (vin, color, extras, car_model_id, engine_id) VALUES 
('1HGCM82633A123456', 'Rojo', 'Navegación, Asientos de cuero', 1, 1),  -- Audi A4
('2HGCM82633A123456', 'Azul', 'Cámara de reversa, Sensores de aparcamiento', 2, 2),  -- Honda Civic
('3HGCM82633A123456', 'Blanco', 'Techo panorámico, Llantas de aleación', 3, 3),  -- Tesla Model 3
('4HGCM82633A123456', 'Negro', 'Sistema de sonido premium, Asientos calefaccionados', 4, 4),  -- Toyota Corolla
('5HGCM82633A123456', 'Gris', 'Control de crucero adaptativo, Faros LED', 5, 5),  -- Volkswagen Golf
('6HGCM82633A123456', 'Verde', 'Paquete deportivo, Frenos de alto rendimiento', 6, 6),  -- BMW 3 Series
('7HGCM82633A123456', 'Amarillo', 'Asistente de mantenimiento de carril, Pantalla táctil', 7, 7),  -- Nissan Qashqai
('8HGCM82633A123456', 'Plata', 'Sistema de climatización, Acceso sin llave', 8, 8),  -- Peugeot 508
('9HGCM82633A123456', 'Marrón', 'Cámara 360°, Asientos ventilados', 9, 9),  -- Renault Clio
('0HGCM82633A123456', 'Violeta', 'Sistema de infoentretenimiento, Conectividad Bluetooth', 10, 10);  -- Hyundai Tucson


INSERT INTO license_plates (plate_number, car_id, state) VALUES 
('DEF5678', (SELECT id FROM car_details WHERE vin='2HGCM82633A123456'), 'Barcelona'),
('GHI9012', (SELECT id FROM car_details WHERE vin='3HGCM82633A123456'), 'Valencia'),
('ABC1234', (SELECT id FROM car_details WHERE vin='1HGCM82633A123456'), 'Madrid'),
('JKL3456', (SELECT id FROM car_details WHERE vin='4HGCM82633A123456'), 'Sevilla'),
('MNO7890', (SELECT id FROM car_details WHERE vin='5HGCM82633A123456'), 'Bilbao'),
('PQR1234', (SELECT id FROM car_details WHERE vin='6HGCM82633A123456'), 'Málaga'),
('STU5678', (SELECT id FROM car_details WHERE vin='7HGCM82633A123456'), 'Zaragoza'),
('VWX9012', (SELECT id FROM car_details WHERE vin='8HGCM82633A123456'), 'Murcia'),
('YZA3456', (SELECT id FROM car_details WHERE vin='9HGCM82633A123456'), 'Palma'),
('BCD7890', (SELECT id FROM car_details WHERE vin='0HGCM82633A123456'), 'Alicante'),
('EFG1234', (SELECT id FROM car_details WHERE vin='1HGCM82633B123456'), 'Granada'),
('HIJ5678', (SELECT id FROM car_details WHERE vin='2HGCM82633B123456'), 'Córdoba'),
('KLM9012', (SELECT id FROM car_details WHERE vin='3HGCM82633B123456'), 'Valladolid'),
('NOP3456', (SELECT id FROM car_details WHERE vin='4HGCM82633B123456'), 'Santiago de Compostela');

INSERT INTO services (name, description, price) VALUES 
('Garantía Extendida', 'Cobertura extendida de garantía por 2 años adicionales', 500.00),
('Mantenimientos Gratuitos', 'Mantenimientos en el concesionario gratuitos por 3 años', 0.00),
('Seguro Todo Riesgo', 'Seguro a todo riesgo por 1 año', 1200.00),
('Asistencia en Carretera', 'Servicio de asistencia en carretera por 3 años', 300.00),
('Revisiones Anuales', 'Revisiones anuales gratuitas durante 5 años', 0.00);


INSERT INTO car_service (car_detail_id, service_id, start_date, end_date) VALUES 
((SELECT id FROM car_details WHERE vin='1HGCM82633A123456'), (SELECT id FROM services WHERE name='Garantía Extendida'), '2023-01-01', '2025-01-01'),
((SELECT id FROM car_details WHERE vin='2HGCM82633A123456'), (SELECT id FROM services WHERE name='Mantenimientos Gratuitos'), '2023-01-01', '2026-01-01'),
((SELECT id FROM car_details WHERE vin='3HGCM82633A123456'), (SELECT id FROM services WHERE name='Seguro Todo Riesgo'), '2023-01-01', '2024-01-01'),
((SELECT id FROM car_details WHERE vin='4HGCM82633A123456'), (SELECT id FROM services WHERE name='Asistencia en Carretera'), '2023-01-01', '2026-01-01'),
((SELECT id FROM car_details WHERE vin='5HGCM82633A123456'), (SELECT id FROM services WHERE name='Revisiones Anuales'), '2023-01-01', '2028-01-01');

