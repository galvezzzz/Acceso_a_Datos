package com.dam.acdat.view;

import java.util.Scanner;
import java.util.List;

import com.dam.acdat.dao.EscritoresDao;
import com.dam.acdat.model.Escritor;
import com.dam.acdat.model.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class BibliotecaConsola {
    public static void main(String[] args) {

        // Configuración de Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EscritoresDao escritoresDao = new EscritoresDao(sessionFactory);

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearEscritor(escritoresDao, scanner);
                    break;
                case 2:
                    obtenerEscritorPorId(escritoresDao, scanner);
                    break;
                case 3:
                    actualizarEscritor(escritoresDao, scanner);
                    break;
                case 4:
                    eliminarEscritor(escritoresDao, scanner);
                    break;
                case 5:
                    listarEscritores(escritoresDao);
                    break;
                case 6:
                    salir = true;
                    break;
                case 7:
                    Escritor escritor = new Escritor();
                    Session session = sessionFactory.openSession();
                    session.beginTransaction();

                    escritor = new Escritor();
                    escritor.setNombre("J.R.R. Tolkien");
                    session.save(escritor);

                    Libro libro = new Libro();
                    libro.setTitulo("El hobbit");
                    libro.setEscritor(escritor);
                    session.save(libro);

                    Libro libro1 = new Libro();
                    libro1.setTitulo("El Señor de los Anillos");
                    libro1.setEscritor(escritor);
                    session.save(libro1);

                    Libro libro2 = new Libro();
                    libro2.setTitulo("El Silmarillion");
                    libro2.setEscritor(escritor);
                    session.save(libro2);

                    session.getTransaction().commit();

                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sessionFactory.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú de Escritores\n" +
                "1. Crear escritor.\n" +
                "2. Obtener escritor por ID.\n" +
                "3. Actualizar escritor.\n" +
                "4. Eliminar escritor.\n" +
                "5. Listar todos los escritores.\n" +
                "6. Salir.\n" +
                "7. Implementación escenario.");
        System.out.print("Escribe tu opción: ");
    }

    private static void crearEscritor(EscritoresDao escritorDao, Scanner scanner) {
        System.out.print("Ingrese el nombre del escritor: ");
        String nombre = scanner.nextLine();
        Escritor escritor = new Escritor();

        escritor.setNombre(nombre);

        escritorDao.guardarEscritor(escritor);

        System.out.println("Escritor creado exitosamente con el ID: " + escritor.getId());
    }

    private static void obtenerEscritorPorId(EscritoresDao escritoresDao, Scanner scanner) {
        System.out.print("Ingrese el ID del escritor: ");
        Long id = scanner.nextLong();

        Escritor escritor = escritoresDao.obtenerEscritorPorId(id);

        if (escritor != null) {
            System.out.println("Escritor encontrado:");
            System.out.println("ID: " + escritor.getId());
            System.out.println("Nombre: " + escritor.getNombre());
        } else {
            System.out.println("Escritor no encontrado.");
        }
    }

    private static void actualizarEscritor(EscritoresDao escritoresDao, Scanner scanner) {
        System.out.print("Ingrese el ID del escritor a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Escritor escritor = escritoresDao.obtenerEscritorPorId(id);
        if (escritor != null) {
            System.out.print("Ingrese el nuevo nombre del escritor: ");
            String nuevoNombre = scanner.nextLine();

            escritor.setNombre(nuevoNombre);
            escritoresDao.actualizaEscritor(escritor);

            System.out.println("Escritor actualizado.");
        } else {
            System.out.println("Escritor no encontrado.");
        }
    }

    private static void eliminarEscritor(EscritoresDao escritoresDao, Scanner scanner) {
        System.out.print("Ingrese el ID del escritor a eliminar: ");
        Long id = scanner.nextLong();

        escritoresDao.eliminarEscritor(id);

        System.out.println("Escritor eliminado exitosamente.");
    }


    private static void listarEscritores(EscritoresDao escritoresDao) {
        List<Escritor> escritores = escritoresDao.obtenerTodosLosEscritores();
        if (escritores.isEmpty()) {
            System.out.println("No hay escritores registrados.");
        } else {
            for (Escritor escritor : escritores) {
                System.out.println(escritor.toString());
            }
        }
    }
}
