package com.dam.acdat.repasofinalthymeleaf.modelo.dao;

import com.dam.acdat.repasofinalthymeleaf.modelo.entidades.Partido;
import org.springframework.data.repository.CrudRepository;

public interface IPartidosDAO extends CrudRepository<Partido, Integer> {
}
