package com.dam.acdat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    public static Connection getConexion() throws SQLException {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/appdietas", "postgres", "iesbelen");

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos");
            System.out.println("Mensaje de error: " + e.getMessage());
            return null;

        }
    }

    public static void createTables() throws SQLException{
        String sqlTablaCentros = "CREATE TABLE CentrosDieteticos" +
                "(    id SERIAL PRIMARY KEY,\n" +
                "    nombre VARCHAR(100) NOT NULL,\n" +
                "    direccion VARCHAR(255) NOT NULL,\n" +
                "    telefono VARCHAR(20),\n" +
                "    email VARCHAR(100),\n" +
                "    horario TEXT);";

        String sqlTablaClientes = "CREATE TABLE Clientes" +
                "(    id SERIAL PRIMARY KEY,\n" +
                "    nombre VARCHAR(100) NOT NULL,\n" +
                "    fecha_nacimiento DATE,\n" +
                "    telefono VARCHAR(20),\n" +
                "    email VARCHAR(100),\n" +
                "    centro_dietetico_id INTEGER REFERENCES CentrosDieteticos(id));";

        Connection con = null;

        try {
            con = getConexion();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlTablaCentros);
            stmt.executeUpdate(sqlTablaClientes);

            con.commit();
            stmt.close();
            System.out.println("Las tablas de la base de datos se han creado correctamente");

        } catch (Exception e) {
            con.rollback();
            System.out.println("Error al crear las tablas");
            System.out.println("Mensaje de error: " + e.getMessage());

        }
    }

    public static void poblateTables() throws SQLException{
        String sqlpoblateCentros = "INSERT INTO centrosdieteticos (nombre, direccion, telefono, email, horario)" +
                "VALUES" +
                " ('Nutrición Integral', 'Av. Siempreviva, 123', '555-1234567', 'nutricion@integral.com', 'Lun-Vie: 9am-2pm y 4pm8pm'), " +
                " ('Bienestar y Salud', 'Calle del Sol, 78', '555-8765432', 'bienestar@salud.com', 'Mar-Jue: 10am-1pm y 3pm7pm')";

        String sqlpoblateClientes = "INSERT INTO clientes (nombre, fecha_nacimiento, telefono, email, centro_dietetico_id)" +
                "VALUES" +
                " ('Juan Pérez', '1980-01-15', '555-1111111', 'juanperez@example.com', 1), " +
                " ('María López', '1992-04-20', '555-2222222', 'marialopez@example.com', 2), " +
                " ('Carlos García', '1975-11-05', '555-3333333', 'carlosgarcia@example.com', 1), " +
                " ('Ana Rodríguez', '1998-07-12', '555-4444444', 'anarodriguez@example.com', 2), " +
                " ('Sofía Martínez', '1995-11-28', '555-5555555', 'sofiamartinez@example.com', 2), " +
                " ('David Hernández', '1982-03-10', '555-6666666', 'davidhernandez@example.com', 1), " +
                " ('Laura Jiménez', '1999-09-25', '555-7777777', 'laurajimenez@example.com', 2), " +
                " ('Pablo Álvarez', '1988-05-18', '555-8888888', 'pabloalvarez@example.com', 1), " +
                " ('Andrea Ruiz', '1991-12-03', '555-9999999', 'andrearuiz@example.com', 2), " +
                " ('Víctor Gómez', '1985-08-22', '555-1234567', 'victorgomez@example.com', 1), " +
                " ('Sara Fernández', '1997-04-15', '555-2345678', 'sarafernandez@example.com', 2), " +
                " ('Miguel Santos', '1983-10-30', '555-3456789', 'miguelsantos@example.com', 1), " +
                " ('Lucía Díaz', '1994-06-17', '555-4567890', 'luciadaz@example.com', 2), " +
                " ('Marcos López', '1987-02-04', '555-5678901', 'marcoslopez@example.com', 1), " +
                " ('Irene García', '1993-08-29', '555-6789012', 'ireneg@example.com', 2); ";

        Connection con = null;

        try {
            con = getConexion();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlpoblateCentros);
            stmt.executeUpdate(sqlpoblateClientes);

            con.commit();
            stmt.close();
            System.out.println("Se han insertado datos de prueba correctamente.");

        } catch (Exception e) {
            con.rollback();
            System.out.println("Error al insertar datos de prueba");
            System.out.println("Mensaje de error: " + e.getMessage());

        }

    }
}
