package com.dam.acdat.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "escritores")
public class Escritor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "escritor", cascade = CascadeType.ALL)
    private Set<Libro> libros;

    public Escritor() {

    }

    public Escritor(long id, String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
