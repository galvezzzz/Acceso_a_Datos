package com.dam.acdat.apirestfutbol2425.modelos.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "partidos")
public class EntidadPartidos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partidos_id_gen")
    @SequenceGenerator(name = "partidos_id_gen", sequenceName = "partidos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local_id")
    private EntidadEquipos equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visitante_id")
    private EntidadEquipos equipoVisitante;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visitante")
    private Integer golesVisitante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntidadEquipos getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EntidadEquipos equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public EntidadEquipos getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(EntidadEquipos equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

}