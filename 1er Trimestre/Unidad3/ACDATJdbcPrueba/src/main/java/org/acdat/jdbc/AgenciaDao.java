package org.acdat.jdbc;

import org.acdat.negocio.Agencia;
import org.acdat.negocio.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDao {
    public List<Agencia> mostrarAgencias(Connection connection) throws SQLException, SQLException {

        List<Agencia> agenciaList = new ArrayList<Agencia>();
        Agencia agencia = null;
        String sql = "SELECT * FROM agencias";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                agencia = new Agencia();
                agencia.setId(resultSet.getInt("agencia_id"));
                agencia.setNombre(resultSet.getString("nombre_agencia"));
                agencia.setDireccion(resultSet.getString("direccion_agencia"));
                agencia.setTelefono(resultSet.getString("telefono_agencia"));
                agenciaList.add(agencia);

            }

            return agenciaList;
        }
    }
    public boolean agregarAgencia(Connection connection,  Agencia agencia) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "INSERT INTO agencias (nombre_agencia, direccion_agencia, telefono_agencia) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, agencia.getNombre());
            preparedStatement.setString(2, agencia.getDireccion());
            preparedStatement.setString(3, agencia.getTelefono());
            res = preparedStatement.executeUpdate();
            if (res > 0) respuesta = true;

        }

        return respuesta;

    }

    public boolean actualizarAgencia(Connection connection,  Agencia agencia) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "UPDATE agencias SET nombre_agencia=?, direccion_agencia=?, telefono_agencia=? WHERE agencia_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, agencia.getNombre());
            preparedStatement.setString(2, agencia.getDireccion());
            preparedStatement.setString(3, agencia.getTelefono());
            preparedStatement.setInt (4, agencia.getId());
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;

        }

        return respuesta;

    }

    public Agencia cargarAgencia (Connection connection, int id) throws SQLException {

        Agencia agencia = null;
        String sql = "SELECT * FROM agencias WHERE agencia_id = " + id;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {

                agencia = new Agencia();
                agencia.setId(resultSet.getInt("agencia_id"));
                agencia.setNombre(resultSet.getString("nombre_agencia"));
                agencia.setDireccion(resultSet.getString("direccion_agencia"));
                agencia.setTelefono(resultSet.getString("telefono_agencia"));

            }

            return agencia;
        }
    }

    public boolean existeAgencia (Connection connection, int id) throws SQLException {

        String sql = "SELECT * FROM agencias WHERE cliente_id = " + id;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()  ) {

                return true;

            } else {

                return false;

            }
        }
    }

    public boolean eliminarAgencia(Connection connection, int agenciaId) throws SQLException {

        boolean respuesta = false;
        int res = 0;

        String sql = "DELETE FROM agencias WHERE agencia_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, agenciaId);
            res = preparedStatement.executeUpdate();
            if (res == 1) respuesta = true;

        }

        return respuesta;

    }
}
