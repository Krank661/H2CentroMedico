--create the table
CREATE TABLE IF NOT EXISTS pacientes (dni VARCHAR(255) PRIMARY KEY, nombre VARCHAR(255), telefono VARCHAR(255), grupo_sanguineo VARCHAR(255), edad INT);
CREATE TABLE IF NOT EXISTS profesionales_de_la_salud(id INT PRIMARY KEY, dni VARCHAR(255), nombre VARCHAR(255), telefono VARCHAR(255), especialidad VARCHAR(255), profesion VARCHAR(255));
--delete initial records to avoid duplicates
DELETE FROM pacientes WHERE dni = '666';
DELETE FROM pacientes WHERE dni = '333';
DELETE FROM pacientes WHERE dni = '111';
DELETE FROM profesionales_de_la_salud WHERE id = 1;
DELETE FROM profesionales_de_la_salud WHERE id = 2;
DELETE FROM profesionales_de_la_salud WHERE id = 3;
--insert initial records
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('666', 'Alguien', '123456', 'APOS', 19);
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('333', 'Anonymous', '654321', 'BPOS', 32);
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('111', 'Ichiban', '000000', 'ONEG', 70);
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(1, '10', 'primero', '1234', 'GENERAL_PRACTICIONER', 'médico');
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(2, '20', 'segundo', '2345', 'NONE', 'paramédico');
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(3, '30', 'tercero', '3456', 'NONE', 'enfermero');
