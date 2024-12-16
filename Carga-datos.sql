
-- Insertar datos en la tabla Cuotas
INSERT INTO Cuotas (modalidad, cuota, situacion) VALUES 
('mensual', 30.00, 'activo'),
('trimestral', 85.00, 'activo'),
('anual', 300.00, 'activo'),
('mensual', 25.00, 'inactivo');  -- Ejemplo de cuota inactiva

-- Insertar datos en la tabla Clientes
INSERT INTO Clientes (nombre, apellidos, email, telefono, estado, idCuota) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', '123456789', 'activo', 1),
('María', 'González', 'maria.gonzalez@example.com', '987654321', 'activo', 2),
('Carlos', 'Ramírez', 'carlos.ramirez@example.com', '456789123', 'activo', 3),
('Ana', 'López', 'ana.lopez@example.com', '789123456', 'inactivo', NULL),
('Laura', 'Fernández', 'laura.fernandez@example.com', '321654987', 'activo', 1);
