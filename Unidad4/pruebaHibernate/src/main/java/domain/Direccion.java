package domain;

import jakarta.persistence.*;
import lombok.extern.apachecommons.CommonsLog;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "direccion", length = 80, nullable = false)
    private String direccion;

    public Direccion() {
    }
}
