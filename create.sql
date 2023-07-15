--create the table
CREATE TABLE IF NOT EXISTS pacientes (dni VARCHAR(255) PRIMARY_KEY, nombre VARCHAR(255), telefono VARCHAR(255), grupo_sanguineo VARCHAR(255), edad INT);
--delete initial records to avoid duplicates
DELETE FROM pacientes WHERE dni = '666';
DELETE FROM pacientes WHERE dni = '333';
--insert initial records
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('666', 'Alguien', '123456', 'APOS', 19);
INSERT INTO pacientes(dni, nombre, telefono, grupo_sanguineo, edad) VALUES ('333', 'Anonymous', '654321', 'BPOS', 32);
