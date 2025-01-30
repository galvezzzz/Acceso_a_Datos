package org.example.springboot.controladores;

import org.example.springboot.modelo.dao.IEmpleadosDAO;
import org.example.springboot.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/empleados")
public class controladorEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados() {
        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    @GetMapping
    public ResponseEntity<EntidadEmpleados> buscarEmpleadoPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if (empleado.isPresent()) {
            return ResponseEntity.ok(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadEmpleados guardarEmpleado(@Validated @RequestBody EntidadEmpleados empleado) {
        return empleadosDAO.save(empleado);
    }

}
