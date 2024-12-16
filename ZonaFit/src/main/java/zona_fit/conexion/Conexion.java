package zona_fit.conexion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static Connection getConexion() throws SQLException {

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/zona_fit_db", "postgres", "iesbelen");
        } catch (Exception e) {
            System.out.println("Error al conectarnos a la BD");
            System.out.println("Mensaje: " + e.getMessage());
            return null;
        }
    }

    public static void actualizarEstructura() {

        //Creación de la tabla Cuota
        crearTablaCuota();

        //Borrado de la columna membresía en clientes
        borrarMembresiaCliente();

        //Añadimos columnas a clientes
        anyadirEmailCliente();
        anyadirTelefonoCliente();
        anyadirEstadoCliente();
        anyadiridCuotaCliente();

    }

    public static void cargarDatosIniciales() throws SQLException {

        cargarDatosCuotas();
        cargarDatosClientes();

    }

    private static void cargarDatosCuotas() throws SQLException {
        Connection con = null;
        try {
            con = getConexion();

            con.setAutoCommit(false);

            Statement s = con.createStatement();

            String sql = "INSERT INTO Cuotas (modalidad, cuota, situacion) VALUES ('mensual', 30.00, 'activo'), ('trimestral', 85.00, 'activo'), ('anual', 300.00, 'activo'), ('mensual', 25.00, 'inactivo');";

            s.executeUpdate(sql);

            con.commit();
        } catch (Exception e) {
            con.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    private static void cargarDatosClientes() throws SQLException {
        Connection con = null;
        try {
            con = getConexion();

            con.setAutoCommit(false);

            Statement s = con.createStatement();

            String sql = "INSERT INTO Clientes (nombre, apellido, email, telefono, estado, idCuota) VALUES ('Juan', 'Pérez', 'juan.perez@example.com', '123456789', 'activo', 1), ('María', 'González', 'maria.gonzalez@example.com', '987654321', 'activo', 2), ('Carlos', 'Ramírez', 'carlos.ramirez@example.com', '456789123', 'activo', 3), ('Ana', 'López', 'ana.lopez@example.com', '789123456', 'inactivo', NULL), ('Laura', 'Fernández', 'laura.fernandez@example.com', '321654987', 'activo', 1);";

            s.executeUpdate(sql);

            con.commit();
        } catch (Exception e) {
            con.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    private static void crearTablaCuota() {
        String sql = "CREATE TABLE Cuotas (idCuota SERIAL PRIMARY KEY, modalidad VARCHAR(20) NOT NULL, cuota DECIMAL(10, 2) NOT NULL, situacion VARCHAR(10) CHECK (situacion IN ('activo', 'inactivo')) NOT NULL)";
        try (Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Tabla Cuotas creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la tabla Cuotas");
            System.err.println("Error: " + e.getMessage());

        }
    }

    private static void borrarMembresiaCliente() {
        String sql = "ALTER TABLE clientes DROP COLUMN membresia";
        try(Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Columna membresía borrada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo borrar la columna membresía");
            System.err.println("Error: " + e.getMessage());

        }
    }

    private static void anyadirEmailCliente() {
        String sql = "ALTER TABLE clientes ADD COLUMN email VARCHAR(100) UNIQUE NOT NULL";
        try(Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Columna email creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la columna email");
            System.err.println("Error: " + e.getMessage());

        }
    }

    private static void anyadirTelefonoCliente() {
        String sql = "ALTER TABLE clientes ADD COLUMN telefono VARCHAR(15)";
        try(Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Columna teléfono creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la columna teléfono");
            System.err.println("Error: " + e.getMessage());

        }
    }

    private static void anyadirEstadoCliente() {
        String sql = "ALTER TABLE clientes ADD COLUMN estado VARCHAR(10) CHECK (estado IN ('activo', 'inactivo')) NOT NULL";
        try(Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Columna estado creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la columna estado");
            System.err.println("Error: " + e.getMessage());

        }
    }

    private static void anyadiridCuotaCliente() {
        String sql = "ALTER TABLE clientes ADD COLUMN idCuota INT references Cuotas(idCuota) on delete set null";
        try(Statement s = Conexion.getConexion().createStatement()) {

            s.executeUpdate(sql);

            System.out.println("Columna idCuota creada con éxito");

        } catch (SQLException e) {

            System.err.println("No se pudo crear la columna idCuota");
            System.err.println("Error: " + e.getMessage());

        }
    }

}