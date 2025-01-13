package com.dam.acdat.presentacion;

import com.dam.acdat.datos.CentroDAO;
import com.dam.acdat.datos.ICentroDAO;
import com.dam.acdat.dominio.Centro;
import com.dam.acdat.model.Conexion;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conexion con = new Conexion();
        boolean salir = false;
        while (!salir) {
            try {
                salir = ejecutarOpciones(mostrarMenu());
            } catch (Exception e) {
                System.out.println("Error al ejecutar el programa");
                System.out.println("Mensaje de error" + e.getMessage());
            }
        }

    }

    private static int mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.print("""
                **App Dietas**
                1. Crear tablas
                2. Cargar datos iniciales
                3. Listar Centros
                4. Buscar Centro
                5. Agregar Centro
                6. Modificar Centro
                7. Eliminar Centro
                8. Salir
                Elige una opción:\s""");

        return sc.nextInt();
    }

    private static boolean ejecutarOpciones(int opcion) throws SQLException {
        Conexion con = new Conexion();
        boolean salir = false;
        switch (opcion) {

            case 1 -> {
                System.out.println("--- Crear tablas ---");
                Conexion.createTables();
            }
            case 2 -> {
                System.out.println("--- Carga de datos iniciales ---");
                Conexion.poblateTables();
            }
            case 3 -> {
                System.out.println("--- Listado de centros ---");
                listarCentros();
            }
            case 4 -> {
                System.out.println("--- Buscar centro ---");
                buscarCentro();
            }
            case 5 -> {
                System.out.println("--- Agregar centro ---");
                agregarCentro();
            }
            case 6 -> {
                System.out.println("--- Modificar centro ---");
                modificarCentro();

            }
            case 7 -> {
                System.out.println("--- Eliminar centro ---");
                eliminarCentro();

            }
            case 8 -> {
                System.out.println("Saliste de la aplicación");
                salir = true;
            }
        }
        System.out.println("");
        return salir;
    }

    private static int pedirID() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el ID: ");
        return sc.nextInt();
    }

    private static String pedirNombre() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        return sc.next();
    }

    private static String pedirDireccion() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la dirección: ");
        return sc.next();
    }

    private static String pedirTelefono() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el teléfono: ");
        return sc.next();
    }

    private static String pedirEmail() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el email: ");
        return sc.next();
    }

    private static String pedirHorario() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el horario: ");
        return sc.next();
    }


    private static void listarCentros() {
        ICentroDAO centroDAO = new CentroDAO();

        List<Centro> centros = centroDAO.listarCentros();
        if (centros.isEmpty()) {
            System.out.println("No hay ningún centro");
        } else {
            for (Centro centro : centros) {
                System.out.println(centro);
            }
        }
    }

    private static void buscarCentro() {
        ICentroDAO centroDAO = new CentroDAO();

        int centroId = pedirID();
        Centro centro = new Centro(centroId);
        if (centroDAO.buscarCentro(centro)) {
            System.out.println("Centro encontrado: " + centro);
        } else {
            System.out.println("No se encontró el centro: " + centro.getId());
        }
    }

    private static void agregarCentro() {
        ICentroDAO centroDAO = new CentroDAO();

        Centro centro = new Centro(pedirID(), pedirNombre(), pedirDireccion(), pedirTelefono(), pedirEmail(), pedirHorario());
        if (centroDAO.agregarCentro(centro)) {
            System.out.println("Centro agregado correctamente");
        } else {
            System.out.println("Error al agregar el centro");
        }
    }

    private static void modificarCentro() {
        ICentroDAO centroDAO = new CentroDAO();

        Centro centro = new Centro(pedirID(), pedirNombre(), pedirDireccion(), pedirTelefono(), pedirEmail(), pedirHorario());
        if (!centroDAO.buscarCentro(new Centro(centro.getId()))) {
            System.out.println("CEntro no encontrado: " + centro.getId());
        } else {
            if (centroDAO.modificarCentro(centro)) {
                System.out.println("Se modifico el centro: " + centro);
            } else {
                System.out.println("No se pudo modificar el centro: " + centro.getId());
            }
        }
    }

    private static void eliminarCentro() {
        ICentroDAO centroDAO = new CentroDAO();

        Centro centro = new Centro(pedirID());

        if (!centroDAO.buscarCentro(new Centro(centro.getId()))) {
            System.out.println("Centro no encontrado: " + centro.getId());
        } else {
            boolean eliminado = centroDAO.eliminarCentro(centro);
            if (eliminado) {
                System.out.println("Centro eliminado");
            } else {
                System.out.println("No se pudo eliminar el centro");
            }
        }
    }
}