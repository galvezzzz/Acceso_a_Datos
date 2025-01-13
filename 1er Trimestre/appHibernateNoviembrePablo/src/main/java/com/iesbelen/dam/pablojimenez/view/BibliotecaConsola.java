package com.iesbelen.dam.pablojimenez.view;

import java.util.Scanner;
import java.util.List;

import com.iesbelen.dam.pablojimenez.dao.AutorDao;
import com.iesbelen.dam.pablojimenez.model.Autor;
import com.iesbelen.dam.pablojimenez.model.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BibliotecaConsola {
    public static void main(String[] args) {
        // Configuración de Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        AutorDao autorDao = new AutorDao(sessionFactory);

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            mostrarMenu();

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 0:
                    Autor autor = new Autor();
                    Session session = sessionFactory.openSession();
                    session.beginTransaction();

                    autor = new Autor();
                    autor.setNombre("J.R.R. Tolkien");
                    session.save(autor);

                    Libro libro = new Libro();
                    libro.setTitulo("El hobbit");
                    libro.setAutor(autor);
                    session.save(libro);

                    Libro libro1 = new Libro();
                    libro1.setTitulo("El Señor de los Anillos");
                    libro1.setAutor(autor);
                    session.save(libro1);

                    Libro libro2 = new Libro();
                    libro2.setTitulo("El Silmarillion");
                    libro2.setAutor(autor);
                    session.save(libro2);

                    session.getTransaction().commit();

                    break;

                case 1:
                    crearAutor(autorDao, scanner);
                    break;
                case 2:
                    obtenerAutorPorId(autorDao, scanner);
                    break;
                case 3:
                    actualizarAutor(autorDao, scanner);
                    break;
                case 4:
                    eliminarAutor(autorDao, scanner);
                    break;
                case 5:
                    listarAutores(autorDao);
                    break;
                case 6:
                    salir = true;
                    break;
                case 7:


                default:
                    System.out.println("Opción inválida.");
            }
        }
        sessionFactory.close();
    }

    private static void mostrarMenu() {
        System.out.println("Menú de Autores\n" +
                "1. Crear autor.\n" +
                "2. Obtener autor por ID.\n" +
                "3. Actualizar autor.\n" +
                "4. Eliminar autor.\n" +
                "5. Listar todos los autores.\n" +
                "6. Salir.\n" +
                "0. Implementación escenario");
        System.out.print("Escribe tu opción: ");
    }

    private static void crearAutor(AutorDao autorDao, Scanner scanner) {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = scanner.nextLine();
        Autor autor = new Autor();

        autor.setNombre(nombre);

        autorDao.guardarAutor(autor);

        System.out.println("Autor creado exitosamente con el ID: " + autor.getId());
    }

    private static void obtenerAutorPorId(AutorDao autorDao, Scanner scanner) {
        System.out.print("Ingrese el ID del autor: ");
        Long id = scanner.nextLong();

        Autor autor = autorDao.obtenerAutorPorId(id);

        if (autor != null) {
            System.out.println("Autor encontrado:");
            System.out.println("ID: " + autor.getId());
            System.out.println("Nombre: " + autor.getNombre());
        } else {
            System.out.println("Autor no encontrado.");
        }
    }

    private static void actualizarAutor(AutorDao autorDao, Scanner scanner) {
        System.out.print("Ingrese el ID del autor a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Autor autor = autorDao.obtenerAutorPorId(id);
        if (autor != null) {
            System.out.print("Ingrese el nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();

            autor.setNombre(nuevoNombre);
            autorDao.actualizarAutor(autor);

            System.out.println("Autor actualizado exitosamente.");
        } else {
            System.out.println("Autor no encontrado.");
        }
    }

    private static void eliminarAutor(AutorDao autorDao, Scanner scanner) {
        System.out.print("Ingrese el ID del autor a eliminar: ");
        Long id = scanner.nextLong();

        autorDao.eliminarAutor(id);

        System.out.println("Autor eliminado exitosamente.");
    }


    private static void listarAutores(AutorDao autorDao) {
        List<Autor> autores = autorDao.obtenerTodosLosAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            for (Autor autor : autores) {
                System.out.println(autor.toString());
            }
        }
    }
}