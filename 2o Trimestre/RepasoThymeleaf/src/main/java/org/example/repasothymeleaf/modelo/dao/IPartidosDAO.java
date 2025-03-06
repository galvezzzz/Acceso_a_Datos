package org.example.repasothymeleaf.modelo.dao;

import org.example.repasothymeleaf.modelo.entidades.EntidadJugadores;
import org.example.repasothymeleaf.modelo.entidades.EntidadPartido;
import org.springframework.data.repository.CrudRepository;

public interface IPartidosDAO extends CrudRepository<EntidadPartido, Integer> {
}
