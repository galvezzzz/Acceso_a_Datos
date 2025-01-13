package com.dam.acdat.primerapi.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento_id_gen")
    @SequenceGenerator(name = "departamento_id_gen", sequenceName = "departamento_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "presupuesto", nullable = false)
    private Double presupuesto;

    @Column(name = "gastos", nullable = false)
    private Double gastos;

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

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

}