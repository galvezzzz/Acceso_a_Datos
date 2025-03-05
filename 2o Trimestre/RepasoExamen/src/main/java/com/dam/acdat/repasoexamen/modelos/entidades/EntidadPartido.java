package com.dam.acdat.repasoexamen.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "partidos")
public class EntidadPartido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partidos_id_gen")
    @SequenceGenerator(name = "partidos_id_gen", sequenceName = "partidos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("equipo_local_id")
    @JoinColumn(name = "equipo_local_id")
    private com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("equipo_visitante_id")
    @JoinColumn(name = "equipo_visitante_id")
    private com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo equipoVisitante;

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

    public com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo equipoVisitante) {
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