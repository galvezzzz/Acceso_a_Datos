package com.dam.acdat.repasoexamen.modelos.daos;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IPartidoDAO extends CrudRepository<EntidadPartido, Integer> {

    @Query("SELECT p FROM EntidadPartido p WHERE p.golesLocal > p.golesVisitante")
    List<EntidadPartido> mostrarPartidosGanadosByEquipoLocal();
}
