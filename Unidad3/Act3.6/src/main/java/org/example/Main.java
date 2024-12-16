package org.example;

import java.sql.*;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        String name;
        int anyo, position = 1;
        PreparedStatement statement = con.prepareStatement("INSERT INTO Asignaturas (nombre, anyo) VALUES (?, ?)");

        System.out.println("Introduce nombre/s y año/s para asignatura/s. Para terminar de introducir, pulsa x");
        System.out.print("Introduce el nombre: ");
        name = sc.next();

        System.out.print("Introduce el año: ");
        anyo = sc.nextInt();

        while(!(name.equals("x") || name.equals("X"))) {
            statement.setString(position, name);
            statement.setInt(position, anyo);
            statement.executeUpdate();
            position++;

            System.out.print("Introduce el nombre: ");
            name = sc.nextLine();
            System.out.print("Introduce el año: ");
            anyo = sc.nextInt();
        }
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