package com.dam.acdat.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    public static Connection getConexion() throws SQLException{
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "iesbelen");

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos");
            System.out.println("Mensaje de error: " + e.getMessage());
            return null;

        }
    }

    public static void createDataBase() throws SQLException {
        String sql = "CREATE DATABASE test";
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "iesbelen");

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            con.close();
            System.out.println("Base de datos creada");

        } catch (Exception e) {
            System.out.println("Error al crear la base de datos");
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    public static void createTables() throws SQLException{
        String sqlTablaAutor = "CREATE TABLE Autor" +
                "(" +
                "   id serial, " +
                "   nombre character(50), " +
                "   PRIMARY KEY (id) " +
                ");";

        String sqlTablaLibro = "CREATE TABLE Libro" +
                "(" +
                "   id serial, " +
                "   titulo character(50), " +
                "   autor_id integer, " +
                "   PRIMARY KEY (id), " +
                "   FOREIGN KEY (autor_id) REFERENCES Autor(id) " +
                "   ON UPDATE CASCADE ON DELETE RESTRICT " +
                ");";

        Connection con = null;

        try {
            con = getConexion();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlTablaAutor);
            stmt.executeUpdate(sqlTablaLibro);

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
        String sqlpoblateAutor = "INSERT INTO Autor (nombre) VALUES ('Brandon Sanderson');" +
                                "INSERT INTO Autor (nombre) VALUES ('Orson Scott Card');";

        String sqlpoblateLibro = "INSERT INTO Libro (titulo, autor_id) VALUES ('Juramentada', 1);" +
                                "INSERT INTO Libro (titulo, autor_id) VALUES ('Palabras Radiantes', 1);" +
                                "INSERT INTO Libro (titulo, autor_id) VALUES ('El Juego de Ender', 2);";

        Connection con = null;

        try {
            con = getConexion();
            con.setAutoCommit(false);

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlpoblateAutor);
            stmt.executeUpdate(sqlpoblateLibro);

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
