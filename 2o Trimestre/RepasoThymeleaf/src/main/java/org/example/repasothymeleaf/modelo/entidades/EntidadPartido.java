package org.example.repasothymeleaf.modelo.entidades;

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
    @JoinColumn(name = "equipo_local_id")
    private EntidadEquipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visitante_id")
    private EntidadEquipo equipoVisitante;

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

    public EntidadEquipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EntidadEquipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public EntidadEquipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(EntidadEquipo equipoVisitante) {
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