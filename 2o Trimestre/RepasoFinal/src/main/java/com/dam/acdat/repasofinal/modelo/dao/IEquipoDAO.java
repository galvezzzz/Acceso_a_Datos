package com.dam.acdat.repasofinal.modelo.dao;

import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadPartido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDAO extends CrudRepository<EntidadEquipo, Integer> {
    public EntidadEquipo findByNombre(String equipo);


}
