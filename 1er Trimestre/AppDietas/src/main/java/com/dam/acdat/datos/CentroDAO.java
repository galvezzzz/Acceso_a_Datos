package com.dam.acdat.datos;

import com.dam.acdat.dominio.Centro;
import com.dam.acdat.model.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CentroDAO implements ICentroDAO {

    @Override
    public List<Centro> listarCentros() {
        List<Centro> centros = new ArrayList<>();

        String sql = "SELECT * FROM centrosdieteticos ORDER BY id";

        try(PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Centro centro = new Centro();
                centro.setId(rs.getInt("id"));
                centro.setNombre(rs.getString("nombre"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setTelefono(rs.getString("telefono"));
                centro.setEmail(rs.getString("email"));
                centro.setHorario(rs.getString("horario"));
                centros.add(centro);
            }

        } catch (Exception e) {
            System.out.println("No se pudo listar los centros");
            System.out.println("Mensaje error: " + e.getMessage());
        }

        return centros;
    }

    @Override
    public boolean buscarCentro(Centro centro) {
        String sql = "SELECT * FROM centrosdieteticos WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)){

            ps.setInt(1, centro.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                centro.setNombre(rs.getString("nombre"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setTelefono(rs.getString("telefono"));
                centro.setEmail(rs.getString("email"));
                centro.setHorario(rs.getString("horario"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se pudo buscar el centro");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregarCentro(Centro centro) {
        String sql = "INSERT INTO centrosdieteticos(id, nombre, direccion, telefono, email, horario) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, centro.getId());
            ps.setString(2, centro.getNombre());
            ps.setString(3, centro.getDireccion());
            ps.setString(4, centro.getTelefono());
            ps.setString(5, centro.getEmail());
            ps.setString(6, centro.getHorario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo agregar el centro");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificarCentro(Centro centro) {
        String sql = "UPDATE centrosdieteticos SET nombre = ?, direccion = ?, telefono = ?, email = ?, horario = ? WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setString(1, centro.getNombre());
            ps.setString(2, centro.getDireccion());
            ps.setString(3, centro.getTelefono());
            ps.setString(4, centro.getEmail());
            ps.setString(5, centro.getHorario());
            ps.setInt(6, centro.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo modificar el centro");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarCentro(Centro centro) {
        String sql = "DELETE FROM centrosdieteticos WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setInt(1, centro.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo eliminar el centro");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }
}
