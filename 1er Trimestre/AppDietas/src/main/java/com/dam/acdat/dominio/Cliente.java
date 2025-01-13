package com.dam.acdat.dominio;

public class Cliente {
    int id;
    String nombre ;
    String fecha_nacimiento ;
    String telefono ;
    String email ;
    int centro_dietetico_id ;

    public Cliente(int id, String nombre, String fecha_nacimiento, String telefono, String email, int centro_dietetico_id) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.centro_dietetico_id = centro_dietetico_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCentro_dietetico_id() {
        return centro_dietetico_id;
    }

    public void setCentro_dietetico_id(int centro_dietetico_id) {
        this.centro_dietetico_id = centro_dietetico_id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", centro_dietetico_id=" + centro_dietetico_id +
                '}';
    }
}
