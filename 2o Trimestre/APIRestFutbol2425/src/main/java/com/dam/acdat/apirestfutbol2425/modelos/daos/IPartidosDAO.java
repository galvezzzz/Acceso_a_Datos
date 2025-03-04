package com.dam.acdat.apirestfutbol2425.modelos.daos;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadPartidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPartidosDAO extends CrudRepository<EntidadPartidos, Integer> {
}
