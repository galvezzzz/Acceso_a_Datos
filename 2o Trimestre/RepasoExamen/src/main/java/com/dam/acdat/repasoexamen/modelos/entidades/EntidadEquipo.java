package com.dam.acdat.repasoexamen.modelos.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonBackReference("jugadores")
    private Set<EntidadJugadores> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    @JsonBackReference("partidos_local")
    private Set<EntidadPartido> partidos_local = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    @JsonBackReference("partidos_visitante")
    private Set<EntidadPartido> partidos_visitante = new LinkedHashSet<>();

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

    public Set<EntidadJugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<EntidadJugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<EntidadPartido> getPartidos_local() {
        return partidos_local;
    }

    public void setPartidos_local(Set<EntidadPartido> partidos_local) {
        this.partidos_local = partidos_local;
    }

    public Set<EntidadPartido> getPartidos_visitante() {
        return partidos_visitante;
    }

    public void setPartidos_visitante(Set<EntidadPartido> partidos_visitante) {
        this.partidos_visitante = partidos_visitante;
    }

}