package com.dam.acdat.repasofinalthymeleaf.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_id_gen")
    @SequenceGenerator(name = "equipos_id_gen", sequenceName = "equipos_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 15)
    private String nombre;

    @Size(max = 255)
    @Column(name = "escudo")
    private String escudo;

    @OneToMany(mappedBy = "equipo")
    private Set<Jugadore> jugadores = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    private Set<Partido> partidos_local = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    private Set<Partido> partidos_visitante = new LinkedHashSet<>();

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

    public Set<Jugadore> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugadore> jugadores) {
        this.jugadores = jugadores;
    }

    public Set<Partido> getPartidos_local() {
        return partidos_local;
    }

    public void setPartidos_local(Set<Partido> partidos_local) {
        this.partidos_local = partidos_local;
    }

    public Set<Partido> getPartidos_visitante() {
        return partidos_visitante;
    }

    public void setPartidos_visitante(Set<Partido> partidos_visitante) {
        this.partidos_visitante = partidos_visitante;
    }

}