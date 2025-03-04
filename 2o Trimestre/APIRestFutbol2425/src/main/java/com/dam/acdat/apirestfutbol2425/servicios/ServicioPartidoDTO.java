package com.dam.acdat.apirestfutbol2425.servicios;

import com.dam.acdat.apirestfutbol2425.modelos.daos.IPartidosDAO;
import com.dam.acdat.apirestfutbol2425.modelos.dtos.PartidosDTO;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadPartidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class ServicioPartidoDTO {

    @Autowired
    IPartidosDAO partidosDAO;

    public ResponseEntity<PartidosDTO> resgistrarPartido(EntidadPartidos partido, EntidadEquipos equipos) {
        PartidosDTO partidosDTO = new PartidosDTO();
        partidosDTO.setEscudoEquipoLocal(equipos.getEscudo());
        partidosDTO.setFechaEquipoLocal(partido.getFecha());
        partidosDTO.setHoraEquipoLocal(partido.getHora());
        partidosDTO.setNombreEquipoLocal(equipos.getNombre());
        partidosDTO.setGolesEquipoLocal(partido.getGolesLocal());
        partidosDTO.setGolesEquipoVisitante(partido.getGolesVisitante());

        return ResponseEntity.ok().body(partidosDTO);
    }
}
