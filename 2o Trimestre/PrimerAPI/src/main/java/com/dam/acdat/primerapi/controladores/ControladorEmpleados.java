package com.dam.acdat.primerapi.controladores;

import com.dam.acdat.primerapi.modelo.dao.IEmpleadoDAO;
import com.dam.acdat.primerapi.modelo.entidades.Empleado;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-res/empleados")
public class
ControladorEmpleados {

    @Autowired
    IEmpleadoDAO empleadoDAO;

    @GetMapping
    public List<Empleado> buscarEmpleados(@RequestParam(name="puesto", required=false) String puesto) {
        if (puesto == null) {
            return (List<Empleado>)empleadoDAO.findAll();
        }else{
            return (List<Empleado>)empleadoDAO.findByPuestoContains(puesto);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable(value = "id") Integer id){
        Optional<Empleado> empleado = empleadoDAO.findById(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok(empleado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado){
        return empleadoDAO.save(empleado);
    }
}
