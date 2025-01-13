package com.dam.acdat.primerapi.modelo.dao;

import com.dam.acdat.primerapi.modelo.entidades.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoDAO extends CrudRepository<Empleado, Integer> {

    List<Empleado> findByPuesto(String puesto);
    List<Empleado> findByDepnoGreaterThanEqual(Integer depno);

    @Query("select e from Empleado e where e.nombre like %:patron%")
    List<Empleado> findByName(@Param("patron") String patron);

    // 4
    List<Empleado> findByNombreStartingWith(String prefijo);

    // 5
    List<Empleado> findByPuestoContaining(String puesto);
}
