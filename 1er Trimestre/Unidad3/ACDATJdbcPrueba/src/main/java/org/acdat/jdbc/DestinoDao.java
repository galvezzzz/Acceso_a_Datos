package org.acdat.jdbc;

import org.acdat.negocio.Destino;
import org.acdat.negocio.Vuelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DestinoDao {

    public List<Destino> mostrarDestinos(Connection connection) throws SQLException, SQLException {

        List<Destino> destinoList = new ArrayList<Destino>();
        Destino destino = null;
        String sql = "SELECT * FROM destinos";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                destino = new Destino();
                destino.setId(resultSet.getInt("destino_id"));
                destino.setDestino(resultSet.getString("nombre_destino"));
                destino.setDescripcion(resultSet.getString("descripcion"));
                destino.setCoste(resultSet.getDouble("costo_estadia"));
                destinoList.add(destino);

            }

            return destinoList;
        }
    }

    public boolean agregarDestino(Connection connection,  Destino destino) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "INSERT INTO destinos (nombre_destino, descripcion, costo_estadia) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, destino.getDestino());
            preparedStatement.setString(2, destino.getDescripcion());
            preparedStatement.setDouble(3, destino.getCoste());
            res = preparedStatement.executeUpdate();
            if (res > 0) respuesta = true;

        }

        return respuesta;

    }

    public boolean actualizarDestino(Connection connection,  Destino destino) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "UPDATE vuelos SET nombre_destino=?, descripcion=?, costo_estadia=? WHERE destino_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, destino.getDestino());
            preparedStatement.setString(2, destino.getDescripcion());
            preparedStatement.setDouble (3, destino.getCoste());
            preparedStatement.setInt (4, destino.getId());

            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;

        }

        return respuesta;
    }

    public Destino cargarDestino (Connection connection, int id) throws SQLException {

        Destino destino = null;
        String sql = "SELECT * FROM destinos WHERE destino_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            //System.out.println("ID\tNombre\t\tCorreo\t\tTeléfono");
            //System.out.println("--------------------------------------------------------------------------");

            while (resultSet.next()) {
                destino = new Destino();
                destino.setId(resultSet.getInt("destino_id"));
                destino.setDestino(resultSet.getString("nombre_destino"));
                destino.setDescripcion(resultSet.getString("descripcion"));
                destino.setCoste(resultSet.getDouble("costo_estadia"));
            }
            // System.out.println();
            return destino;
        }

    }

    public boolean existeDestino (Connection connection, int id) throws SQLException {

        String sql = "SELECT * FROM destinos WHERE destino_id = " + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()  ) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean eliminarDestino(Connection connection, int destinoId) throws SQLException {
        boolean respuesta = false;
        int res = 0;

        String sql = "DELETE FROM destinos WHERE destino_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, destinoId);
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;
        }
        return respuesta;
    }
}
