package org.acdat.vista;

import org.acdat.negocio.Vuelo;

import java.sql.SQLException;
import java.util.Scanner;

public class VistaVuelo {
    Vuelo vuelo = new Vuelo();


    public void mostrarMenu() {
        System.out.println("Menú de CRUD de Vuelos");
        System.out.println("1. Mostrar Vuelos");
        System.out.println("2. Agregar Vuelo");
        System.out.println("3. Actualizar Vuelo");
        System.out.println("4. Eliminar Vuelo");
        System.out.println("5. Consulta de verificación de inserción de vuelos");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
    }

    public void crudVuelo() throws SQLException {
        String respuesta = "";

        while (true) {
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(mostrarVuelos());
                    break;
                case 2:
                    this.agregarVuelo();
                    break;
                case 3:
                    this.actualizarVuelo();
                    break;
                case 4:
                    this.eliminarVuelo();
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

    public String mostrarVuelos() throws SQLException {
        String respuesta;
        respuesta = vuelo.mostrarVuelos();
        return respuesta;
    }

    public void agregarVuelo() {
        Scanner scanner = new Scanner(System.in);
        Vuelo vuelo = new Vuelo();

        System.out.print("Ingrese el origen del Vuelo: ");
        vuelo.setOrigen(scanner.nextLine());
        System.out.print("Ingrese el destino del Vuelo: ");
        vuelo.setDestino(scanner.nextLine());
        System.out.print("Ingrese fecha de salida del Vuelo: ");
        vuelo.setFecha_salida(scanner.nextLine());
        System.out.print("Ingrese el fecha de llegada del Vuelo: ");
        vuelo.setFecha_llegada(scanner.nextLine());
        System.out.print("Ingrese el costo del Vuelo: ");
        vuelo.setCosto(Double.parseDouble(scanner.nextLine()));

        try {
            if (vuelo.agregarVuelo()) {
                System.out.println("Vuelo agregado correctamente");
            } else {
                System.out.println("Error al crear el vuelo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarVuelo() throws SQLException {
        System.out.println(this.mostrarVuelos());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del vuelo que desea actualizar: ");
        int vueloId = scanner.nextInt();
        scanner.nextLine();
        vuelo.setId(vueloId);
        if (vuelo.existeVuelo()) {
            if (vuelo.cargarVuelo()) {
                System.out.print("Ingrese el nuevo origen del Vuelo: ");
                vuelo.setOrigen(scanner.nextLine());
                System.out.print("Ingrese el nuevo destino del Vuelo: ");
                vuelo.setDestino(scanner.nextLine());
                System.out.print("Ingrese la nueva fecha de salida del Vuelo: ");
                vuelo.setFecha_salida(scanner.nextLine());
                System.out.print("Ingrese la nueva fecha de llegada del Vuelo: ");
                vuelo.setFecha_llegada(scanner.nextLine());
                System.out.print("Ingrese el nuevo costo del Vuelo: ");
                vuelo.setCosto(Double.parseDouble(scanner.nextLine()));
            }
            try {
                if (vuelo.actualizarVuelo()) {
                    System.out.println("Vuelo actualizado correctamente");
                } else {
                    System.out.println("Error al actualizar el Vuelo");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Vuelo seleccionado " + vueloId + " no existe");
        }
    }

    public void eliminarVuelo() throws SQLException {

        System.out.println(this.mostrarVuelos());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Vuelo que desea eliminar: ");
        int vueloId = scanner.nextInt();
        scanner.nextLine();
        vuelo.setId(vueloId);
        if (vuelo.existeVuelo()) {
            try {
                if (vuelo.eliminarVuelo()) {
                    System.out.println("Vuelo eliminado correctamente");
                } else {
                    System.out.println("Error al eliminar el vuelo");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El Vuelo seleccionado " + vueloId + " no existe");
        }
    }
}
