package com.dam.acdat.apirestfutbol2425.controladores;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import com.dam.acdat.apirestfutbol2425.servicios.ServicioEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/futbol-api/equipo")
public class ControladorEquipos {

    @Autowired
    ServicioEquipos servicioEquipos;

    @GetMapping
    public List<EntidadEquipos> buscarEquipos() {
        return servicioEquipos.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipos> buscarEquipoById(@PathVariable int id) {
        return servicioEquipos.buscarEquipoById(id);
    }


    @PostMapping
    public ResponseEntity<?> crearEquipo(@Validated @RequestBody EntidadEquipos entidadEquipos) {
        if (servicioEquipos.crearEquipo(entidadEquipos)) {
            return ResponseEntity.ok().body("Se ha creado el equipo");
        }else{
            return ResponseEntity.badRequest().body("No se pudo crear el equipo");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@RequestBody EntidadEquipos entidadEquipos) {
        if (servicioEquipos.eliminarEquipo(entidadEquipos.getId())) {
            return ResponseEntity.ok().body("Se ha borrado el equipo");
        }else{
            return ResponseEntity.badRequest().body("No se pudo borrar el equipo");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEquipo(@RequestBody EntidadEquipos entidadEquipos) {
        if (servicioEquipos.modificarEquipo(entidadEquipos.getId(), entidadEquipos)){
            return ResponseEntity.ok().body("Se ha modificado el equipo");
        }else{
            return ResponseEntity.badRequest().body("No se pudo modificar el equipo");
        }
    }
}
