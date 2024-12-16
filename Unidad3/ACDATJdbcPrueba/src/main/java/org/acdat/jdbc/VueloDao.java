package org.acdat.jdbc;

import org.acdat.negocio.Agencia;
import org.acdat.negocio.Cliente;
import org.acdat.negocio.Vuelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDao {
    public List<Vuelo> mostrarVuelos(Connection connection) throws SQLException, SQLException {

        List<Vuelo> vueloList = new ArrayList<Vuelo>();
        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("vuelo_id"));
                vuelo.setOrigen(resultSet.getString("origen"));
                vuelo.setDestino(resultSet.getString("destino"));
                vuelo.setFecha_salida(resultSet.getString("fecha_salida"));
                vuelo.setFecha_llegada(resultSet.getString("fecha_llegada"));
                vuelo.setCosto(resultSet.getDouble("costo"));
                vueloList.add(vuelo);

            }

            return vueloList;
        }
    }

    public boolean agregarVuelo(Connection connection,  Vuelo vuelo) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "INSERT INTO vuelos (origen, destino, fecha_salida, fecha_llegada, costo) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, vuelo.getOrigen());
            preparedStatement.setString(2, vuelo.getDestino());
            preparedStatement.setString(3, vuelo.getFecha_salida());
            preparedStatement.setString(3, vuelo.getFecha_llegada());
            preparedStatement.setDouble(3, vuelo.getCosto());
            res = preparedStatement.executeUpdate();
            if (res > 0) respuesta = true;

        }

        return respuesta;

    }

    public boolean actualizarVuelo(Connection connection,  Vuelo vuelo) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "UPDATE vuelos SET origen=?, destino=?, fecha_salida=?, fecha_llegada=?, costo=? WHERE agencia_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, vuelo.getOrigen());
            preparedStatement.setString(2, vuelo.getDestino());
            preparedStatement.setString(3, vuelo.getFecha_salida());
            preparedStatement.setString (4, vuelo.getFecha_llegada());
            preparedStatement.setDouble (5, vuelo.getCosto());
            preparedStatement.setInt (6, vuelo.getId());

            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;

        }

        return respuesta;
    }

    public Vuelo cargarVuelo (Connection connection, int id) throws SQLException {

        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos WHERE vuelo_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            //System.out.println("ID\tNombre\t\tCorreo\t\tTeléfono");
            //System.out.println("--------------------------------------------------------------------------");

            while (resultSet.next()) {
                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("vuelo_id"));
                vuelo.setOrigen(resultSet.getString("origen"));
                vuelo.setDestino(resultSet.getString("destino"));
                vuelo.setFecha_salida(resultSet.getString("fecha_salida"));
                vuelo.setFecha_llegada(resultSet.getString("fecha_llegada"));
                vuelo.setCosto(resultSet.getDouble("costo"));
            }
            // System.out.println();
            return vuelo;
        }

    }

    public boolean existeVuelo (Connection connection, int id) throws SQLException {

        String sql = "SELECT * FROM vuelos WHERE vuelo_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()  ) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean eliminarVuelo(Connection connection, int vueloId) throws SQLException {
        boolean respuesta = false;
        int res = 0;

        String sql = "DELETE FROM vuelos WHERE vuelo_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vueloId);
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;
        }
        return respuesta;
    }
}
