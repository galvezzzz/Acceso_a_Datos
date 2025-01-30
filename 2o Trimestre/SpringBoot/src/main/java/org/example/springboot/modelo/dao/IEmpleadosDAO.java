package org.example.springboot.modelo.dao;

import org.example.springboot.modelo.entidades.EntidadEmpleados;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosDAO extends CrudRepository<EntidadEmpleados, Integer> {
    EntidadEmpleados findByPuesto(String puesto);
    EntidadEmpleados findByDepnoGreaterThanEquals(int depno);

    /*
    @Query("select e from EntidadEmpleados e where e.nombre like %:patron%")
    EntidadEmpleados findByName(@Param("patron") String patron);
    */
}
