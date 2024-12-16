package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try{
            //1. Registramos el driver
            Class.forName("org.postgresql.Driver");

            //2. Cadena de conexión a la base de datos
            String url = "jdbc:postgresql://localhost:5432/institutofp";
            String user = "postgres";
            String password = "iesbelen";
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database");

            // Creación de la base de datos e implementación de datos
            crearDatabase(con);
            crearTabla(con);
            rellenarTabla(con);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se puede cargar el controlador.");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearDatabase(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String SQLsentence = "CREATE DATABASE InstitutoFP";
        statement.executeUpdate(SQLsentence);
    }

    public static void crearTabla(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String SQLsentence1 = "CREATE TABLE Asignaturas (codigo serial, nombre char (50), anyo int)";
        statement.executeUpdate(SQLsentence1);

    }

    public static void rellenarTabla(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String SQLsentence2 = "INSERT INTO Asignaturas (nombre, anyo) VALUES ('Acceso a datos', 2);" +
                "INSERT INTO Asignaturas (nombre, anyo) VALUES ('Entornos de desarrollo', 1);" +
                "INSERT INTO Asignaturas (nombre, anyo) VALUES ('Sistemas de gestión de bases de datos', 1);" +
                "INSERT INTO Asignaturas (nombre, anyo) VALUES ('Servicios y procesos', 2);";
        statement.executeUpdate(SQLsentence2);
    }
}