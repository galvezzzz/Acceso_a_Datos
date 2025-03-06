package org.example.repasothymeleaf.modelo.dao;

import org.example.repasothymeleaf.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

public interface IJugadoresDAO extends CrudRepository<EntidadJugadores, Integer> {
}
