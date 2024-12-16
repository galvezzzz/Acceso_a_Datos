package zona_fit.dominio;

import java.util.Objects;

public class Cuota {

    private int idCuota;
    private String modalidad;
    private double cuota;
    private String situacion;

    public Cuota() {}

    public Cuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public Cuota(String modalidad, double cuota, String situacion) {
        this.modalidad = modalidad;
        this.cuota = cuota;
        this.situacion = situacion;
    }

    public Cuota(int idCuota, String modalidad, double cuota, String situacion) {
        this.idCuota = idCuota;
        this.modalidad = modalidad;
        this.cuota = cuota;
        this.situacion = situacion;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "idCuota=" + idCuota +
                ", modalidad='" + modalidad + '\'' +
                ", cuota=" + cuota +
                ", situacion='" + situacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuota cuota1 = (Cuota) o;
        return idCuota == cuota1.idCuota && Double.compare(cuota, cuota1.cuota) == 0 && Objects.equals(modalidad, cuota1.modalidad) && Objects.equals(situacion, cuota1.situacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuota, modalidad, cuota, situacion);
    }
}
