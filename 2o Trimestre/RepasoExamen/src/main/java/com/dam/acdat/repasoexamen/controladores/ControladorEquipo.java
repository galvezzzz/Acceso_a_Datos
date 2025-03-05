package com.dam.acdat.repasoexamen.controladores;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import com.dam.acdat.repasoexamen.servicios.ServicioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    @Autowired
    private ServicioEquipo servicioEquipo;

    @GetMapping
    public List<EntidadEquipo> buscarEquipos() {
        return servicioEquipo.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipo> buscarEquipoPorId(@PathVariable int id) {
        return servicioEquipo.buscarEquipoById(id);
    }

    @PostMapping
    public EntidadEquipo crearEquipo(@RequestBody EntidadEquipo entidadEquipo) {
        return servicioEquipo.crearEquipo(entidadEquipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable int id) {
        if (servicioEquipo.borrarEquipo(id)){
            return ResponseEntity.ok().body("Equipo eliminado");
        }else{
            return ResponseEntity.badRequest().body("Equipo no existe");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEquipo(@RequestBody EntidadEquipo entidadEquipo, @PathVariable int id) {
        if (servicioEquipo.actualizarEquipo(entidadEquipo, id)){
            return ResponseEntity.ok().body("Equipo actualizado");
        }else{
            return ResponseEntity.badRequest().body("Equipo no existe");
        }
    }

}
