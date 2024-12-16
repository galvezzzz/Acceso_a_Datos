package com.dam.acdat.presentacion;

import com.dam.acdat.conexion.Conexion;
import com.dam.acdat.datos.implementacion.AutorDAO;
import com.dam.acdat.dominio.Autor;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Autor a = new Autor(2, "JRR Tolkien");

        try {
            AutorDAO aDAO = new AutorDAO();
            aDAO.updateObject(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

