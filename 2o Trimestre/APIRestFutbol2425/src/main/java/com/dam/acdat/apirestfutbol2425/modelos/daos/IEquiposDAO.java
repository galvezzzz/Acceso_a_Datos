package com.dam.acdat.apirestfutbol2425.modelos.daos;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquiposDAO extends CrudRepository<EntidadEquipos, Integer> {
}
