package com.dam.acdat.repasoexamen.controladores;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/jugador")
public class ControladorJugadores {

    @Autowired
    private ControladorJugadores controladorJugadores;

    @GetMapping
    public Set<EntidadEquipo> buscarJugadorPorNombreEquipo(){
        return controladorJugadores.buscarJugadorPorNombreEquipo();
    }
}
