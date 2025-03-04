package com.dam.acdat.apirestfutbol2425.controladores;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import com.dam.acdat.apirestfutbol2425.servicios.ServicioEquipos;
import com.dam.acdat.apirestfutbol2425.servicios.ServicioJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/futbol-api/jugador")
public class ControladorJugadores {

    @Autowired
    ServicioJugador servicioJugador;

    @PostMapping
    public ResponseEntity<?> crearJugadorValidado(@Validated @RequestBody EntidadJugadores jugador) {
        if (servicioJugador.crearJugadorValidado(jugador)) {
            return ResponseEntity.ok().body("Se ha creado el jugador");
        }else{
            return ResponseEntity.badRequest().body("No se pudo crear el jugador");
        }
    }
}