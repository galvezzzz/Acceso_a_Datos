package org.example.springboot.controladores;

import org.apache.coyote.Response;
import org.example.springboot.modelo.dao.IDepartamentosDAO;
import org.example.springboot.modelo.dao.IEmpleadosDAO;
import org.example.springboot.modelo.dto.EmpleadosDTO;
import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.example.springboot.modelo.entidades.EntidadEmpleados;
import org.example.springboot.modelo.servicio.ServicioEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-res/empleados")
public class ControladorEmpleados {

    @Autowired
    ServicioEmpleados servicioEmpleados;

    @GetMapping
    public List<EntidadEmpleados> buscarEmpleados() {
        return servicioEmpleados.buscarEmpleados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadEmpleados> buscarEmpleadoPorId(@PathVariable(value = "id") int id) {
        return servicioEmpleados.buscarEmpleadoPorId(id);

    }

    @PostMapping
    public EntidadEmpleados guardarEmpleado(@Validated @RequestBody EntidadEmpleados empleado) {
        return servicioEmpleados.guardarEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id) {
        return servicioEmpleados.borrarEmpleado(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody EntidadEmpleados nuevoEmpleado,
                                                @PathVariable(value = "id") int id) {
        return servicioEmpleados.actualizarEmpleado(nuevoEmpleado, id);
    }

    // DTO
    @GetMapping("/dto/{id}")
    public ResponseEntity<EmpleadosDTO> buscarEmpleadoDTOporId(@PathVariable(value = "id") int id) {
        return servicioEmpleados.buscarEmpleadoDTOporId(id);
    }
}
