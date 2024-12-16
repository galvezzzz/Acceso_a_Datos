package zona_fit.datos.implementado;

import zona_fit.conexion.Conexion;
import zona_fit.datos.ICuotasDAO;
import zona_fit.dominio.Cuota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuotasDAO implements ICuotasDAO {

    @Override
    public List<Cuota> listarCuota() {

        List<Cuota> cuotas = new ArrayList<>();

        String sql = "SELECT * FROM cuotas ORDER BY idCuota";

        try(PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cuota cuota = new Cuota();
                cuota.setIdCuota(rs.getInt("idCuota"));
                cuota.setModalidad(rs.getString("modalidad"));
                cuota.setCuota(rs.getDouble("cuota"));
                cuota.setSituacion(rs.getString("situacion"));
                cuotas.add(cuota);
            }

        } catch (Exception e) {
            System.out.println("No se pudo listar las cuotas");
            System.out.println("Mensaje error: " + e.getMessage());
        }

        return cuotas;
    }

    @Override
    public boolean buscarCuotasPorId(Cuota claseCuota) {

        String sql = "SELECT * FROM cuotas WHERE idCuota = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)){

            ps.setInt(1, claseCuota.getIdCuota());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                claseCuota.setModalidad(rs.getString("modalidad"));
                claseCuota.setCuota(rs.getDouble("cuota"));
                claseCuota.setSituacion(rs.getString("situacion"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("No se pudo buscar la cuota");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean agregarCuotas(Cuota claseCuota) {
        String sql = "INSERT INTO cuotas(modalidad, cuota, sotuacion) VALUES(?,?,?)";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
            ps.setString(1, claseCuota.getModalidad());
            ps.setDouble(2, claseCuota.getCuota());
            ps.setString(3, claseCuota.getSituacion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo agregar la cuota");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificarCuotas(Cuota claseCuota) {
        String sql = "UPDATE cuotas SET modalidad = ?, cuota = ?, situacion = ? WHERE idCuota = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setString(1, claseCuota.getModalidad());
            ps.setDouble(2, claseCuota.getCuota());
            ps.setString(3, claseCuota.getSituacion());
            ps.setInt(4, claseCuota.getIdCuota());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo modificar la cuota");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarCuotas(Cuota claseCuota) {
        String sql = "DELETE FROM cuotas WHERE idCuota = ?";

        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {

            ps.setInt(1, claseCuota.getIdCuota());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("No se pudo eliminar la cuota");
            System.out.println("Mensaje error: " + e.getMessage());
        }
        return false;
    }
}
