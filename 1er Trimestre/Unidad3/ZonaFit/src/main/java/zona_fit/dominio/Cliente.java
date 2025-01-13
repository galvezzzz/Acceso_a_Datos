package zona_fit.dominio;

import java.util.Objects;

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String estado;
    private int idCuota;

    public Cliente(){}

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombre, String apellido, String email, String telefono, String estado, int idCuota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.idCuota = idCuota;
    }

    public Cliente(int id, String nombre, String apellido, String email, String telefono, String estado, int idCuota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.idCuota = idCuota;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado='" + estado + '\'' +
                ", idCuota=" + idCuota +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && idCuota == cliente.idCuota && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(email, cliente.email) && Objects.equals(telefono, cliente.telefono) && Objects.equals(estado, cliente.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, email, telefono, estado, idCuota);
    }
}
