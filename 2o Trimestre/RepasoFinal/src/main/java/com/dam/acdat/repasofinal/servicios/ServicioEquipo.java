package com.dam.acdat.repasofinal.servicios;

import com.dam.acdat.repasofinal.modelo.dao.IEquipoDAO;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
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

    public Optional<EntidadEquipo> buscarEquiposPorId(Integer id){
        return equipoDAO.findById(id);
    }

    public EntidadEquipo guardarEquipo(EntidadEquipo entidadEquipo){
        return equipoDAO.save(entidadEquipo);
    }

    public boolean eliminarEquipo(Integer id){
        Optional<EntidadEquipo> equipo = equipoDAO.findById(id);
        if(equipo.isPresent()){
            equipoDAO.delete(equipo.get());
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarEquipo(EntidadEquipo entidadEquipo, Integer id){
        Optional<EntidadEquipo> equipo = equipoDAO.findById(id);
        if(equipo.isPresent()){
            equipo.get().setId(entidadEquipo.getId());
            equipo.get().setNombre(entidadEquipo.getNombre());
            equipo.get().setEscudo(entidadEquipo.getEscudo());
            equipoDAO.save(equipo.get());
            return true;
        }else{
            return false;
        }
    }
}
