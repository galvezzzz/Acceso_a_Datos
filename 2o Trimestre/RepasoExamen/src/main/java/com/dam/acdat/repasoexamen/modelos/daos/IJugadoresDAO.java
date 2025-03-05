package com.dam.acdat.repasoexamen.modelos.daos;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

public interface IJugadoresDAO extends CrudRepository<EntidadJugadores, Integer> {
}
