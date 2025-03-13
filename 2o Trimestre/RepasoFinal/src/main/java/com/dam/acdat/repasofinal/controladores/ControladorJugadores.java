package com.dam.acdat.repasofinal.controladores;

import com.dam.acdat.repasofinal.modelo.dao.IEquipoDAO;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadJugadores;
import com.dam.acdat.repasofinal.servicios.ServicioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/jugador")
public class ControladorJugadores {

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    ServicioJugadores servicioJugadores;

    @GetMapping("/{equipo}")
    public Set<EntidadJugadores> buscarJugadoresPorEquipo(@PathVariable String equipo) {
        EntidadEquipo equipos = equipoDAO.findByNombre(equipo);
        return equipos.getJugadores();
    }

    @PostMapping
    public EntidadJugadores crearJugador(@RequestBody EntidadJugadores jugador) {
        return servicioJugadores.crearJugadorValidado(jugador);
    }
}
