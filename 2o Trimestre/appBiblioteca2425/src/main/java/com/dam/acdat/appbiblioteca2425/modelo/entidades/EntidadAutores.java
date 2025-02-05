package com.dam.acdat.appbiblioteca2425.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "autores")
public class EntidadAutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "autores_id_gen")
    @SequenceGenerator(name = "autores_id_gen", sequenceName = "autores_id_autor_seq", allocationSize = 1)
    @Column(name = "id_autor", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Size(max = 50)
    @Column(name = "pais", length = 50)
    private String pais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}