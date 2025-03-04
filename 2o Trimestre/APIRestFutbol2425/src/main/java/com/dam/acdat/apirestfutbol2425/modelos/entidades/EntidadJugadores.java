package com.dam.acdat.apirestfutbol2425.modelos.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class EntidadJugadores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugadores_id_gen")
    @SequenceGenerator(name = "jugadores_id_gen", sequenceName = "jugadores_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "posicion", length = 90)
    private String posicion;

    @Column(name = "dorsal", length = 2)
    private Integer dorsal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private EntidadEquipos equipo;

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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public EntidadEquipos getEquipo() {
        return equipo;
    }

    public void setEquipo(EntidadEquipos equipo) {
        this.equipo = equipo;
    }

}