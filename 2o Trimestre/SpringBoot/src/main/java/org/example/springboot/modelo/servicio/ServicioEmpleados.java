package org.example.springboot.modelo.servicio;

import org.example.springboot.modelo.dao.IDepartamentosDAO;
import org.example.springboot.modelo.dao.IEmpleadosDAO;
import org.example.springboot.modelo.dto.EmpleadosDTO;
import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.example.springboot.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleados {

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @Autowired
    IDepartamentosDAO departamentosDAO;

    public List<EntidadEmpleados> buscarEmpleados() {
        return (List<EntidadEmpleados>) empleadosDAO.findAll();
    }

    public ResponseEntity<EntidadEmpleados> buscarEmpleadoPorId(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if (empleado.isPresent()) {
            return ResponseEntity.ok().body(empleado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public EntidadEmpleados guardarEmpleado(@Validated @RequestBody EntidadEmpleados empleado) {
        return empleadosDAO.save(empleado);
    }

    public ResponseEntity<?> borrarEmpleado(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (empleado.isPresent()) {
            empleadosDAO.deleteById(id);
            return ResponseEntity.ok().body("Borrado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> actualizarEmpleado(@RequestBody EntidadEmpleados nuevoEmpleado,
                                                @PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (empleado.isPresent()) {
            empleado.get().setNombre(nuevoEmpleado.getNombre());
            empleado.get().setPuesto(nuevoEmpleado.getPuesto());
            empleado.get().setDepno(nuevoEmpleado.getDepno());
            empleadosDAO.save(empleado.get());
            return ResponseEntity.ok().body("Actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DTO
    public ResponseEntity<EmpleadosDTO> buscarEmpleadoDTOporId(@PathVariable(value = "id") int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);

        if (empleado.isPresent()) {
            Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(empleado.get().getDepno().getId());

            EmpleadosDTO empleadosDTO = new EmpleadosDTO();
            empleadosDTO.setNombre(empleado.get().getNombre());
            empleadosDTO.setPuesto(empleado.get().getPuesto());
            empleadosDTO.setDepno(departamento.get().getId());
            empleadosDTO.setEmpno(empleado.get().getId());
            empleadosDTO.setDepartamentoNombre(departamento.get().getNombre());
            empleadosDTO.setDepartamentoUbicacion(departamento.get().getUbicacion());

            return ResponseEntity.ok().body(empleadosDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
