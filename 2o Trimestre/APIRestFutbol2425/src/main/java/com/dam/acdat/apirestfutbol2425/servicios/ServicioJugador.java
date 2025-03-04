package com.dam.acdat.apirestfutbol2425.servicios;

import com.dam.acdat.apirestfutbol2425.modelos.daos.IEquiposDAO;
import com.dam.acdat.apirestfutbol2425.modelos.daos.IJugadoresDAO;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioJugador {

    @Autowired
    IEquiposDAO equiposDAO;

    @Autowired
    IJugadoresDAO jugadoresDAO;

    public List<EntidadJugadores> buscarJugadorByNombreEquipo(String nombre) {

        EntidadJugadores jugadores = new EntidadJugadores();
        if (jugadores.getEquipo().equals(nombre)) {
            return (List<EntidadJugadores>) jugadoresDAO.findAll();
        }else{
            return null;
        }
    }

    public boolean crearJugadorValidado (@Validated @RequestBody EntidadJugadores jugador){
        if(!jugadoresDAO.existsById(jugador.getId())){
            jugadoresDAO.save(jugador);
            return true;
        }else{
            return false;
        }
    }

    /*
    public boolean buscarJugadorByNombreEquipo(String nombre, EntidadJugadores jugadores) {
        Optional<EntidadEquipos> equipos = equiposDAO.findById(nombre);

        if(equipos.isPresent()) {
            equipos.get().setNombre(nuevoEquipo.getNombre());
            equipos.get().setEscudo(nuevoEquipo.getEscudo());
            equipos.get().setId(nuevoEquipo.getId());
            equiposDAO.save(equipos.get());
            return true;
        } else {
            return false;
        }
    }

     */
}