package com.dam.acdat.repasofinal.servicios;

import com.dam.acdat.repasofinal.modelo.dao.IEquipoDAO;
import com.dam.acdat.repasofinal.modelo.dao.IJugadoresDAO;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServicioJugadores {

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    IJugadoresDAO jugadoresDAO;

    public Set<EntidadJugadores> buscarJugadoresPorNombreEquipo(String nombreEquipo) {
        EntidadEquipo equipo = equipoDAO.findByNombre(nombreEquipo);
        return equipo.getJugadores();
    }

    public EntidadJugadores crearJugadorValidado(EntidadJugadores jugador) {
        return jugadoresDAO.save(jugador);
    }
}
