package com.dam.acdat.primerapi.controladores;

import com.dam.acdat.primerapi.modelo.dao.IEmpleadoDAO;
import com.dam.acdat.primerapi.modelo.entidades.Empleado;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-res/empleados")
public class ControladorEmpleados {

    @Autowired
    IEmpleadoDAO empleadoDAO;

    @GetMapping
    public List<Empleado> buscarEmpleados(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable(value = "id") Integer id){
        return null;
    }

    @PostMapping
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado){
        return null;
    }
}
