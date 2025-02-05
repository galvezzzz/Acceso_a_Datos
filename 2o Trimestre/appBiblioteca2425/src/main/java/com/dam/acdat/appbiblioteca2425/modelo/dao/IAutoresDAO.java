package com.dam.acdat.appbiblioteca2425.modelo.dao;

import com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadAutores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAutoresDAO extends CrudRepository<EntidadAutores, Integer> {

    List<EntidadAutores> buscarAutores();

    Optional<EntidadAutores> buscarAutorPorId(Integer id);

    void guardarAutor(EntidadAutores autor);

    void borrarAutor(Integer id);
}
