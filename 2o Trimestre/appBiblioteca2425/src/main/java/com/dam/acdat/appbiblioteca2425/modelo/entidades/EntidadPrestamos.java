package com.dam.acdat.appbiblioteca2425.modelo.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
public class EntidadPrestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "prestamos_id_gen")
    @SequenceGenerator(name = "prestamos_id_gen", sequenceName = "prestamos_id_prestamo_seq", allocationSize = 1)
    @Column(name = "id_prestamo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro")
    private EntidadLibros idLibro;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadUsuarios idUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EntidadLibros getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(EntidadLibros idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadUsuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

}