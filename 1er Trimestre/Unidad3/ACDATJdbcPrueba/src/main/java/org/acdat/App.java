package org.acdat;

import org.acdat.vista.VistaVuelo;

import java.nio.charset.MalformedInputException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        VistaVuelo vistaVuelo = new VistaVuelo();

        vistaVuelo.crudVuelo();
    }
}
