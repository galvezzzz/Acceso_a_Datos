package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            //1. Registramos el driver
            Class.forName("org.postgresql.Driver");

            //2. Cadena de conexión a la base de datos
            String url = "jdbc:postgresql://localhost:5432/Empleados";
            String user = "postgres";
            String password = "iesbelen";
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database");

            Statement statement = con.createStatement();

            // TABLAS Y CONTENIDO

            String SQLsentence0 = "CREATE TABLE departamento (\n" +
                    "  id SERIAL PRIMARY KEY,\n" +
                    "  nombre VARCHAR(100) NOT NULL,\n" +
                    "  presupuesto DOUBLE PRECISION NOT NULL,\n" +
                    "  gastos DOUBLE PRECISION NOT NULL\n" +
                    ");";

            String SQLsentence1 = "CREATE TABLE empleado (\n" +
                    "  id SERIAL PRIMARY KEY,\n" +
                    "  nif VARCHAR(9) NOT NULL UNIQUE,\n" +
                    "  nombre VARCHAR(100) NOT NULL,\n" +
                    "  apellido1 VARCHAR(100) NOT NULL,\n" +
                    "  apellido2 VARCHAR(100),\n" +
                    "  id_departamento INT,\n" +
                    "  FOREIGN KEY (id_departamento) REFERENCES departamento(id)\n" +
                    ");";

            String SQLsentence2 = "INSERT INTO departamento VALUES(1, 'Desarrollo', 120000, 6000);\n" +
                    "INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);\n" +
                    "INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);\n" +
                    "INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000);\n" +
                    "INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000);\n" +
                    "INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0);\n" +
                    "INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000);";

            String SQLsentence3 = "INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1);\n" +
                    "INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2);\n" +
                    "INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3);\n" +
                    "INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4);\n" +
                    "INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5);\n" +
                    "INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1);\n" +
                    "INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2);\n" +
                    "INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3);\n" +
                    "INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2);\n" +
                    "INSERT INTO empleado VALUES(10, '46384486H', 'Diego','Flores', 'Salas', 5);\n" +
                    "INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1);\n" +
                    "INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL);\n" +
                    "INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL);";

            statement.executeUpdate(SQLsentence0);
            statement.executeUpdate(SQLsentence1);
            statement.executeUpdate(SQLsentence2);
            statement.executeUpdate(SQLsentence3);

            // 3.7
            /*
            1. (RESUELTO) Usando la base de datos de empleados; crear una nueva función almacenada para enumerar todos los empleados en un puesto específico.

            2. Crear otra función que devuelva empleados pertenecientes a un departamento específico.

            3. Crear una función para enumerar todos los empleados cuyo nombre coincida con un patrón usando comodines, por ejemplo, el patrón "p%" devolverá "Pérez", "Peláez".

            4. Crear una aplicación Java que permita llamar a cualquiera de las funciones anteriores.
             */

        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se puede cargar el controlador.");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}