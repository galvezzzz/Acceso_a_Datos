package com.dam.acdat.apirestfutbol2425.modelos.daos;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJugadoresDAO extends CrudRepository<EntidadJugadores, Integer> {
    //void buscarJugadorByNombreEquipo(String nombre);
}
