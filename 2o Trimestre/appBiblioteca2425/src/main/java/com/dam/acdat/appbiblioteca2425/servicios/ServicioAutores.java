package com.dam.acdat.appbiblioteca2425.servicios;

import com.dam.acdat.appbiblioteca2425.modelo.dao.IAutoresDAO;
import com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAutores{

    @Autowired
    private IAutoresDAO autoresDAO;

    public List<EntidadAutores> buscarAutores() {
        return this.autoresDAO.buscarAutores();
    }

    public Optional<EntidadAutores> buscarAutorPorId(Integer id) {
        return this.autoresDAO.buscarAutorPorId(id);
    }

    public void borrarAutor(Integer id) {
        this.autoresDAO.borrarAutor(id);
    }

    public void guardarAutor(EntidadAutores autor) {
        this.autoresDAO.save(autor);
    }
}
