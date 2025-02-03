package org.example.springboot.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados")
public class EntidadEmpleados {
    @Id
    @Column(name = "empno", nullable = false)
    private Integer id;

    @Basic
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 10, message = "El nombre debe tener entre 2 y 10 caracteres")
    @Column(name = "nombre", nullable = true, length = 10)
    private String nombre;

    @Column(name = "puesto", length = 15)
    private String puesto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "depno")
    @JsonBackReference("empleados")
    private EntidadDepartamentos depno;

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public EntidadDepartamentos getDepno() {
        return depno;
    }

    public void setDepno(EntidadDepartamentos depno) {
        this.depno = depno;
    }

}