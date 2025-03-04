package com.dam.acdat.apirestfutbol2425.modelos.dtos;

import com.dam.acdat.apirestfutbol2425.modelos.daos.IEquiposDAO;

import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;


public class PartidosDTO {
    String nombreEquipoLocal;
    String escudoEquipoLocal;
    LocalDate fechaEquipoLocal;
    LocalTime horaEquipoLocal;
    Integer golesEquipoLocal;
    Integer golesEquipoVisitante;

    public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }

    public String getEscudoEquipoLocal() {
        return escudoEquipoLocal;
    }

    public LocalDate getFechaEquipoLocal() {
        return fechaEquipoLocal;
    }

    public LocalTime getHoraEquipoLocal() {
        return horaEquipoLocal;
    }

    public Integer getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public Integer getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setNombreEquipoLocal(String nombreEquipoLocal) {
        this.nombreEquipoLocal = nombreEquipoLocal;
    }

    public String setEscudoEquipoLocal(String escudoEquipoLocal) {
        return escudoEquipoLocal;
    }

    public void setFechaEquipoLocal(LocalDate fechaEquipoLocal) {
        this.fechaEquipoLocal = fechaEquipoLocal;
    }

    public void setHoraEquipoLocal(LocalTime horaEquipoLocal) {
        this.horaEquipoLocal = horaEquipoLocal;
    }

    public void setGolesEquipoLocal(Integer golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public void setGolesEquipoVisitante(Integer golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
}
