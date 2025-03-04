package com.dam.acdat.apirestfutbol2425.controladores;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadPartidos;
import com.dam.acdat.apirestfutbol2425.servicios.ServicioPartidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("futbol-api/partidodto")
public class ControladorPartidoDTO {

    @Autowired
    ServicioPartidoDTO servicioPartidoDTO;


    @GetMapping
    public ResponseEntity<?> registrarPartido() {
        EntidadPartidos partidos = new EntidadPartidos();
        EntidadEquipos equipos = new EntidadEquipos();

        return servicioPartidoDTO.resgistrarPartido(partidos, equipos);
    }
}
