--create the table
CREATE TABLE IF NOT EXISTS pacientes (dni VARCHAR(255) PRIMARY KEY, nombre VARCHAR(255), telefono VARCHAR(255), grupo_sanguineo VARCHAR(255), edad INT);
CREATE TABLE IF NOT EXISTS profesionales_de_la_salud(id INT PRIMARY KEY, dni VARCHAR(255), nombre VARCHAR(255), telefono VARCHAR(255), especialidad VARCHAR(255), profesion VARCHAR(255));
--delete initial records to avoid duplicates
DELETE FROM pacientes WHERE dni = '42512851L';
DELETE FROM pacientes WHERE dni = '75462653K';
DELETE FROM pacientes WHERE dni = '68769297X';
DELETE FROM profesionales_de_la_salud WHERE id = 1;
DELETE FROM profesionales_de_la_salud WHERE id = 2;
DELETE FROM profesionales_de_la_salud WHERE id = 3;
--insert initial records
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('42512851L', 'Alguien', '123456', 'APOS', 19);
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('75462653K', 'Anonymous', '654321', 'BPOS', 32);
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('68769297X', 'Ichiban', '000000', 'ONEG', 70);
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(1, '48585751E', 'primero', '1234', 'GENERAL_PRACTICIONER', 'médico');
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(2, '81006411C', 'segundo', '2345', 'NONE', 'paramédico');
INSERT INTO profesionales_de_la_salud(id, dni, nombre, telefono, especialidad, profesion) VALUES(3, '50361490T', 'tercero', '3456', 'NONE', 'enfermero');
