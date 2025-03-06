package com.dam.acdat.repasoexamen.controladores;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores;
import com.dam.acdat.repasoexamen.servicios.ServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/jugador")
public class ControladorJugadores {

    @Autowired
    private ServicioJugadores servicioJugadores;

    @GetMapping("/{equipo}")
    public Set<EntidadJugadores> buscarJugadorPorNombreEquipo(@PathVariable (value = "equipo") String equipo) {
        return servicioJugadores.buscarJugadoresPorEquipo(equipo);
    }

    @PostMapping
    public EntidadJugadores crearJugadorValidado(@RequestBody EntidadJugadores entidadJugadores) {
        return servicioJugadores.crearJugadorValidado(entidadJugadores);
    }
}
