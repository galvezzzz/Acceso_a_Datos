package org.example.springboot.controladores;


import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.example.springboot.modelo.servicio.ServicioDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-res/departamentos")
public class ControladorDepartamentos {

    @Autowired
    ServicioDepartamentos servicioDepartamentos;

    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamentos() {
        return servicioDepartamentos.buscarDepartamentos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadDepartamentos> buscarDepartamentoPorId(@PathVariable int id) {
        return servicioDepartamentos.buscarDepartamentoPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> guardarDepartamentos(@RequestBody EntidadDepartamentos entidadDepartamentos) {
        if (servicioDepartamentos.guardarDepartamento(entidadDepartamentos)) {
            return ResponseEntity.ok().body("Se ha guardado el departamento");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarDepartamentos(EntidadDepartamentos entidadDepartamentos) {
        if (servicioDepartamentos.actualizarDepartamento(entidadDepartamentos)) {
            return ResponseEntity.ok().body("Se ha actualizado el departamento");
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarDepartamentos(EntidadDepartamentos entidadDepartamentos) {
        if (servicioDepartamentos.eliminarDepartamento(entidadDepartamentos)) {
            return ResponseEntity.ok().body("Se ha eliminado el departamento");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
