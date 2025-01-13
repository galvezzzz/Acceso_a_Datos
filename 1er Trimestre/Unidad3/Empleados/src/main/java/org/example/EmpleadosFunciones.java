package org.example;

import java.sql.*;

public class EmpleadosFunciones {


    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/empleados_db";
        String user = "tu_usuario";
        String password = "tu_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a la base de datos.");

            // Llamar a las funciones almacenadas
            listarEmpleadosPorPuesto(conn, "Desarrollo");
            listarEmpleadosPorDepartamento(conn, 2);
            listarEmpleadosPorPatron(conn, "P%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función para listar empleados por puesto
    public static void listarEmpleadosPorPuesto(Connection conn, String puesto) {
        String sql = "SELECT * FROM listar_empleados_por_puesto(?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, puesto);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\nEmpleados en el puesto: " + puesto);
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " +
                            rs.getString("nombre") + " " +
                            rs.getString("apellido1") + " " +
                            rs.getString("apellido2"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función para listar empleados por departamento
    public static void listarEmpleadosPorDepartamento(Connection conn, int departamentoId) {
        String sql = "SELECT * FROM listar_empleados_por_departamento(?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, departamentoId);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\nEmpleados en el departamento: " + departamentoId);
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " +
                            rs.getString("nombre") + " " +
                            rs.getString("apellido1") + " " +
                            rs.getString("apellido2"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Función para listar empleados por patrón
    public static void listarEmpleadosPorPatron(Connection conn, String patron) {
        String sql = "SELECT * FROM listar_empleados_por_patron(?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patron);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\nEmpleados cuyo nombre coincide con el patrón: " + patron);
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " +
                            rs.getString("nombre") + " " +
                            rs.getString("apellido1") + " " +
                            rs.getString("apellido2"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


