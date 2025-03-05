package com.dam.acdat.thymeleaf.modelo.dao;

import com.dam.acdat.thymeleaf.modelo.entidades.EntidadEmpleados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {
    //List<EntidadEmpleados> findByDepno(int depno);
}
