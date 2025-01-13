package com.dam.acdat.datos.implementacion;

import com.dam.acdat.conexion.Conexion;
import com.dam.acdat.datos.IObjectDAO;
import com.dam.acdat.dominio.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements IObjectDAO {
    @Override
    public List<Object> getObjects() throws SQLException {
        List<Object> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        Connection con = null;

        try {
            con = Conexion.getConexion();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
                autores.add(autor);
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Ha habido un error listando los autores");
            System.out.println("Mensaje del error: " + e.getMessage());

        }

        return autores;
    }

    @Override
    public boolean addObject(Object object) throws SQLException {
        Autor autor = (Autor) object;
        String sql = "INSERT INTO Autor (nombre) VALUES (?)";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();

            con.commit();
            ps.close();
            return true;

        } catch (Exception e) {
            con.rollback();
            System.out.println("Ha ocurrido un error insertando el autor.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }

    @Override
    public Object getObject(Object object) throws SQLException {
        Autor autorId = (Autor) object;
        Autor autor = new Autor();
        String sql = "SELECT * FROM Autor WHERE id = ?";
        Connection con = null;

        try {
            con = Conexion.getConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, autorId.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
            }

            rs.close();
            ps.close();

            return autor;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error buscando el autor.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return null;

        }
    }

    @Override
    public boolean updateObject(Object object) throws SQLException {
        Autor autor = (Autor) object;
        String sql = "UPDATE Autor SET nombre = ? WHERE id = ?";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            con.setAutoCommit(false);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();

            con.commit();
            ps.close();
            return true;

        } catch (Exception e) {
            con.rollback();
            System.out.println("Ha ocurrido un error actualizando el autor.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }

    @Override
    public boolean deleteObject(Object object) throws SQLException {
        Autor autor = (Autor) object;
        String sql = "DELETE FROM Autor WHERE id = ?";
        Connection con = null;

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, autor.getId());
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error eliminando el autor.");
            System.out.println("Mensaje del error: " + e.getMessage());
            return false;

        }
    }
}
