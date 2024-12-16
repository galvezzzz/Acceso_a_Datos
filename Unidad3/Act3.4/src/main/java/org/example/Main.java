package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try{
            //1. Registramos el driver
            Class.forName("org.postgresql.Driver");

            //2. Cadena de conexión a la base de datos
            String url = "jdbc:postgresql://localhost:5432/institutofp";
            String user = "postgres";
            String password = "iesbelen";
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to database");

            anyadirTema(con);


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

    public static void anyadirTema(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String SQLsentence3 = "INSERT INTO Asignaturas (nombre, anyo) VALUES ('Lenguajes de marcas', 1);";
        statement.executeUpdate(SQLsentence3);
    }

    public static void anyadirHora(Connection con) throws SQLException {
        Statement statement = con.createStatement();
        String SQLsentence4 = "ALTER TABLE Asignaturas ADD COLUMN Horas integer";
        statement.executeUpdate(SQLsentence4);
    }
}