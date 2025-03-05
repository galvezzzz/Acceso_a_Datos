package com.dam.acdat.repasoexamen.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class EntidadEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_id_gen")
    @SequenceGenerator(name = "equipos_id_gen", sequenceName = "equipos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Column(name = "escudo")
    private String escudo;

    @OneToMany(mappedBy = "equipo")
    @JsonIgnoreProperties("jugadores")
    private Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    @JsonBackReference("equipo_local")
    private Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> equipo_local = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    @JsonBackReference("equipo_visitante")
    private Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> equipo_visitante = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> equipo_local) {
        this.equipo_local = equipo_local;
    }

    public Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(Set<com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido> equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }

}