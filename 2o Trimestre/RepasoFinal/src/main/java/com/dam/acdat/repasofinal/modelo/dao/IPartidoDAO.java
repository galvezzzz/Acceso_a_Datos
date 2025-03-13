package com.dam.acdat.repasofinal.modelo.dao;

import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadPartido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPartidoDAO extends CrudRepository<EntidadPartido, Integer> {

    @Query("SELECT p FROM EntidadPartido p WHERE p.golesLocal > p.golesVisitante")
    public List<EntidadPartido> mostrarPartidosGanadosByEquipoLocal();
}
