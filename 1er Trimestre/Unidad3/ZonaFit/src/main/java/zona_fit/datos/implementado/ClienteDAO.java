package zona_fit.datos.implementado;

import zona_fit.conexion.Conexion;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarClientes() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes ORDER BY id";

        try(PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setIdCuota(rs.getInt("idCuota"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("No se pudo listar a los clientes");
            System.out.println("Mensaje error: " + e.getMessage());
        }

        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {

        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)){

            ps.setInt(1, cliente.getId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setIdCuota(rs.getInt("idCuota"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se pudo buscar el cliente");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes(nombre, apellido, email, telefono, estado, idCuota) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEstado());
            ps.setInt(6, cliente.getIdCuota());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo agregar el cliente");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {

        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, telefono = ?, estado = ?, idCuota = ? WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEstado());
            ps.setInt(6, cliente.getIdCuota());
            ps.setInt(7, cliente.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo modificar el cliente");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo eliminar el cliente");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

}
