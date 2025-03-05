package com.dam.acdat.repasoexamen.servicios;

import com.dam.acdat.repasoexamen.modelos.daos.IEquipoDAO;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipo {

    @Autowired
    private IEquipoDAO equipoDAO;

    public List<EntidadEquipo> buscarEquipos(){
        return (List<EntidadEquipo>) equipoDAO.findAll();
    }

    public Optional<EntidadEquipo> buscarEquipoById(int id){
        return equipoDAO.findById(id);
    }

    public EntidadEquipo crearEquipo(EntidadEquipo equipo){
        return equipoDAO.save(equipo);
    }

    public boolean borrarEquipo(int id){
        Optional<EntidadEquipo> equipo = equipoDAO.findById(id);

        if(equipo.isPresent()){
            equipoDAO.delete(equipo.get());
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarEquipo(EntidadEquipo equipo, int id) {
        Optional<EntidadEquipo> equipoActual = equipoDAO.findById(id);
        if (equipoActual.isPresent()) {
            equipoActual.get().setId(equipo.getId());
            equipoActual.get().setNombre(equipo.getNombre());
            equipoActual.get().setEscudo(equipo.getEscudo());
            equipoDAO.save(equipoActual.get());
            return true;
        }else{
            return false;
        }
    }
}
