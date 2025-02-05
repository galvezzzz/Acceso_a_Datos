package com.dam.acdat.appbiblioteca2425.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class EntidadLibros {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libros_id_gen")
    @SequenceGenerator(name = "libros_id_gen", sequenceName = "libros_id_libro_seq", allocationSize = 1)
    @Column(name = "id_libro", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private EntidadAutores idAutor;

    @Size(max = 50)
    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public EntidadAutores getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(EntidadAutores idAutor) {
        this.idAutor = idAutor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

}