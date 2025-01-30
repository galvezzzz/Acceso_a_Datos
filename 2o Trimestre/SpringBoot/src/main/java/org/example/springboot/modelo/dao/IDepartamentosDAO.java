package org.example.springboot.modelo.dao;

import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos, Integer> {
}
