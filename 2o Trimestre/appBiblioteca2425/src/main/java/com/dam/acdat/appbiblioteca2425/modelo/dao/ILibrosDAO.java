package com.dam.acdat.appbiblioteca2425.modelo.dao;

import com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadLibros;
import org.springframework.data.repository.CrudRepository;

public interface ILibrosDAO extends CrudRepository<EntidadLibros, Integer> {
}
