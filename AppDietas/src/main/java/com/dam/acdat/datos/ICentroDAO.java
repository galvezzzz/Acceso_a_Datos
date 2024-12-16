package com.dam.acdat.datos;

import com.dam.acdat.dominio.Centro;

import java.util.List;

public interface ICentroDAO {
    List<Centro> listarCentros();

    boolean buscarCentro(Centro centro);

    boolean agregarCentro(Centro centro);

    boolean modificarCentro(Centro centro);

    boolean eliminarCentro(Centro centro);
}
