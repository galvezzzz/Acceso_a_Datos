package com.dam.acdat.repasoexamen.modelos.daos;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import org.springframework.data.repository.CrudRepository;

public interface IEquipoDAO extends CrudRepository<EntidadEquipo, Integer> {

    public EntidadEquipo findByNombre(String nombre);
}
