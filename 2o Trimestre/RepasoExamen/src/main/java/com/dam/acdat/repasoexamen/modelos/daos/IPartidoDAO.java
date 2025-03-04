package com.dam.acdat.repasoexamen.modelos.daos;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido;
import org.springframework.data.repository.CrudRepository;

public interface IPartidoDAO extends CrudRepository<EntidadPartido, Integer> {
}
