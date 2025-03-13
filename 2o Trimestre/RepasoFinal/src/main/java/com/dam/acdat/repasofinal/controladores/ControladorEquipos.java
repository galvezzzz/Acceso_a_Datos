package com.dam.acdat.repasofinal.controladores;

import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.servicios.ServicioEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipos {

    @Autowired
    private ServicioEquipo servicioEquipo;

    @GetMapping
    public List<EntidadEquipo> buscarEquipos(){
        return servicioEquipo.buscarEquipos();
    }

    @GetMapping("/{id}")
    public Optional<EntidadEquipo> buscarEquipoId(@PathVariable (value = "id") int id){
        return servicioEquipo.buscarEquiposPorId(id);
    }

    @PostMapping
    public EntidadEquipo crearEquipo(@RequestBody EntidadEquipo entidadEquipo){
        return servicioEquipo.guardarEquipo(entidadEquipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipo(@PathVariable (value = "id") int id){
        if (servicioEquipo.eliminarEquipo(id)){
            return ResponseEntity.ok().body("Equipo eliminado");
        }else{
            return ResponseEntity.badRequest().body("Error al eliminar el equipo");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEquipo(@RequestBody EntidadEquipo entidadEquipo, @PathVariable (value = "id") int id){
        if (servicioEquipo.actualizarEquipo(entidadEquipo, id)){
            return ResponseEntity.ok().body("Equipo actualizado");

        }else{
            return ResponseEntity.badRequest().body("Error al actualizar el equipo");
        }
    }
}
