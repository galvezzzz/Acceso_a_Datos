package zona_fit.datos;

import zona_fit.dominio.Cuota;

import java.util.List;

public interface ICuotasDAO {

    List<Cuota> listarCuota();

    boolean buscarCuotasPorId(Cuota claseCuota);

    boolean agregarCuotas(Cuota claseCuota);

    boolean modificarCuotas(Cuota claseCuota);

    boolean eliminarCuotas(Cuota claseCuota);

}
