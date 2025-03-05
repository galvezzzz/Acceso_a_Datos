package com.dam.acdat.thymeleaf.modelo.dao;

import com.dam.acdat.thymeleaf.modelo.entidades.EntidadDepartamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentosDAO extends CrudRepository<EntidadDepartamentos, Integer> {
}
