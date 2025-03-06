package org.example.repasothymeleaf.modelo.dao;

import org.example.repasothymeleaf.modelo.entidades.EntidadEquipo;
import org.example.repasothymeleaf.modelo.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;

public interface IEquipoDAO extends CrudRepository<EntidadEquipo, Integer> {
}
