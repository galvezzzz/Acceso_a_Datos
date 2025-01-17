package com.dam.acdat.accesodatosapi.modelo.dao;

import com.dam.acdat.accesodatosapi.modelo.entidades.Departamento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartamentoDAO extends CrudRepository<Departamento, Integer> {

    // 1
    Departamento findByNombre(String nombre);
    // 2
    Departamento findByUbicacion(String ubicacion);
    // 3
    Departamento findByNombreIgnoreCase(String nombre);
    // 4
    Departamento findByUbicacionIgnoreCase(String ubicacion);

    Departamento findByUbicacionEqualsOrUbicacionEquals(String firstPlace, String secondPlace);
}
