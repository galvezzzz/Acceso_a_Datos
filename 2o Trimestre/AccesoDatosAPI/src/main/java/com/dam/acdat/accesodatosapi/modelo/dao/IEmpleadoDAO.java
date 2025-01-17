package com.dam.acdat.accesodatosapi.modelo.dao;

import com.dam.acdat.accesodatosapi.modelo.entidades.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoDAO extends CrudRepository<Empleado, Integer> {

    Empleado findByPuesto(String puesto);
    //Empleado findByDepnoGreaterThanEqual(Integer depno);

    @Query("select e from Empleado e where e.nombre like %:patron%")
    Empleado findByName(@Param("patron") String patron);

    // 4
    Empleado findByNombreStartingWith(String prefijo);

    // 5
//    Empleado findByPuestoContaining(String puesto);
}
