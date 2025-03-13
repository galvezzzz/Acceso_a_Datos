package com.dam.acdat.repasofinalthymeleaf.modelo.dao;

import com.dam.acdat.repasofinalthymeleaf.modelo.entidades.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDAO extends CrudRepository<Equipo, Integer> {
}
