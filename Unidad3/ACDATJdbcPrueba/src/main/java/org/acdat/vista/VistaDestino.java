package org.acdat.vista;

import org.acdat.negocio.Destino;
import org.acdat.negocio.Vuelo;


import java.sql.SQLException;
import java.util.Scanner;

public class VistaDestino {
    Destino destino = new Destino();


    public void mostrarMenu() {
        System.out.println("Menú de CRUD de destino");
        System.out.println("1. Mostrar destinos");
        System.out.println("2. Agregar destino");
        System.out.println("3. Actualizar destino");
        System.out.println("4. Eliminar destino");
        System.out.println("5. Consulta de verificación de inserción de destinos");
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
                    System.out.println(mostrarDestinos());
                    break;
                case 2:
                    this.agregarDestino();
                    break;
                case 3:
                    this.actualizarDestino();
                    break;
                case 4:
                    this.eliminarDestino();
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

    public String mostrarDestinos() throws SQLException {
        String respuesta;
        respuesta = destino.mostrarDestino();
        return respuesta;
    }

    public void agregarDestino() {
        Scanner scanner = new Scanner(System.in);
        Destino destino = new Destino();

        System.out.print("Ingrese el destino del destino: ");
        destino.setDestino(scanner.nextLine());
        System.out.print("Ingrese la descripción del destino: ");
        destino.setDescripcion(scanner.nextLine());
        System.out.print("Ingrese el coste del destino: ");
        destino.setCoste(Double.parseDouble(scanner.nextLine()));

        try {
            if (destino.agregarDestino()) {
                System.out.println("Destino agregado correctamente");
            } else {
                System.out.println("Error al crear el destino");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarDestino() throws SQLException {
        System.out.println(this.mostrarDestinos());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del destino que desea actualizar: ");
        int destinoId = scanner.nextInt();
        scanner.nextLine();
        destino.setId(destinoId);
        if (destino.existeDestino()) {
            if (destino.cargarDestino()) {
                System.out.print("Ingrese el destino del destino: ");
                destino.setDestino(scanner.nextLine());
                System.out.print("Ingrese la descripción del destino: ");
                destino.setDescripcion(scanner.nextLine());
                System.out.print("Ingrese el coste del destino: ");
                destino.setCoste(Double.parseDouble(scanner.nextLine()));
            }
            try {
                if (destino.actualizarDestino()) {
                    System.out.println("Destino actualizado correctamente");
                } else {
                    System.out.println("Error al actualizar el destino");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("El destino seleccionado " + destinoId + " no existe");
        }
    }

    public void eliminarDestino() throws SQLException {

        System.out.println(this.mostrarDestinos());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del destino que desea eliminar: ");
        int destinoId = scanner.nextInt();
        scanner.nextLine();
        destino.setId(destinoId);
        if (destino.existeDestino()) {
            if (destino.eliminarDestino()) {
                System.out.println("Destino eliminado correctamente");
            } else {
                System.out.println("Error al eliminar el destino");
            }

        } else {
            System.out.println("El destino seleccionado " + destinoId + " no existe");
        }
    }
}