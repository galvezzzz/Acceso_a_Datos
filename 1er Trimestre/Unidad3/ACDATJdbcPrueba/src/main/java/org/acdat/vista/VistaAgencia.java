package org.acdat.vista;

import org.acdat.negocio.Agencia;

import java.sql.SQLException;
import java.util.Scanner;

public class VistaAgencia {
    Agencia agencia = new Agencia();


    public void mostrarMenu() {
        System.out.println("Menú de CRUD de Agencias");
        System.out.println("1. Mostrar Agencias");
        System.out.println("2. Agregar Agencia");
        System.out.println("3. Actualizar Agencia");
        System.out.println("4. Eliminar Agencia");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    public void crudAgencia() throws SQLException {
        String respuesta = "";

        while (true) {
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(mostrarAgencias());
                    break;
                case 2:
                    this.agregarAgencia();
                    break;
                case 3:
                    this.actualizarAgencia();
                    break;
                case 4:
                    this.eliminarAgencia();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
            System.out.println(respuesta);
        }
    }

    public String mostrarAgencias() throws SQLException {
        String respuesta;
        respuesta = agencia.mostrarAgencias();
        return respuesta;
    }

    public void agregarAgencia() {
        Scanner scanner = new Scanner(System.in);
        Agencia agencia = new Agencia();

        System.out.print("Ingrese el nombre de la agencia: ");
        agencia.setNombre(scanner.nextLine());
        System.out.print("Ingrese la dirección de la agencia: ");
        agencia.setDireccion(scanner.nextLine());
        System.out.print("Ingrese el teléfono de la agencia: ");
        agencia.setTelefono(scanner.nextLine());

        try {
            if (agencia.agregarAgencia()) {
                System.out.println("Agencia agregado correctamente");
            } else {
                System.out.println("Error al crear el agencia");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarAgencia() throws SQLException {
        System.out.println(this.mostrarAgencias());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la agencia que desea actualizar: ");
        int agenciaId = scanner.nextInt();
        scanner.nextLine();
        agencia.setId(agenciaId);
        if (agencia.existeAgencia()) {
            if (agencia.cargarAgencia()) {
                System.out.print("Ingrese el nuevo nombre de la agencia (" + agencia.getNombre() + "): ");
                agencia.setNombre(scanner.nextLine());
                System.out.print("Ingrese el nuevo dirección de la agencia(" + agencia.getDireccion() + "): ");
                agencia.setDireccion(scanner.nextLine());
                System.out.print("Ingrese el nuevo teléfono de la agencia(" + agencia.getTelefono() + "): ");
                agencia.setTelefono(scanner.nextLine());
            }
            try {
                if (agencia.actualizarAgencia()) {
                    System.out.println("Agencia actualizado correctamente");
                } else {
                    System.out.println("Error al actualizar el agencia");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("La agencia seleccionada " + agenciaId + " no existe");
        }
    }

    public void eliminarAgencia() throws SQLException {

        System.out.println(this.mostrarAgencias());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la agencia que desea eliminar: ");
        int agenciaId = scanner.nextInt();
        scanner.nextLine();
        agencia.setId(agenciaId);
        if (agencia.existeAgencia()) {
            try {
                if (agencia.eliminarAgencia()) {
                    System.out.println("Agencia eliminada correctamente");
                } else {
                    System.out.println("Error al eliminar la agencia");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("La agencia seleccionada " + agenciaId + " no existe");
        }
    }
}
