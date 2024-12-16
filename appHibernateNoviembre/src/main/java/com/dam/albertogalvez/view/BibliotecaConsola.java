package com.dam.albertogalvez.view;

public class BibliotecaConsola
{
    public static void main( String[] args )
    {
        System.out.println("Menú de autores");
        System.out.println("1. Crear autor");
        System.out.println("2. Obtener autor por ID");
        System.out.println("3. Actualizar autor");
        System.out.println("4. Actualizar autor");
        System.out.println("5. Listar todos los autores");
        System.out.println("6. Salir");

        System.out.print("Ingrese una opción: ");

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

// Obtener una sesión
        Session session = sessionFactory.openSession();
        session.beginTransaction();

// Crear un nuevo autor
        Autor autor = new Autor();
        autor.setNombre("J.R.R. Tolkien");
        session.save(autor);

// Crear un nuevo libro
        Libro libro = new Libro();
        libro.setTitulo("El hobbit");
        libro.setAutor(autor);
        session.save(libro);

// Crear un nuevo libro
        Libro libro1 = new Libro();
        libro1.setTitulo("El Señor de los Anillos");
        libro1.setAutor(autor);
        session.save(libro1);

// Crear un nuevo libro
        Libro libro2 = new Libro();
        libro2.setTitulo("El Silmarillion");
        libro2.setAutor(autor);
        session.save(libro2);

        // Crear un nuevo libro
        Libro libro3 = new Libro();
        libro3.setTitulo("La Comunidad del Anillo");
        libro3.setAutor(autor);
        session.save(libro3);

        System.out.println("Obras del autor: ");
        System.out.println(autor.toString());

// Commit de la transacción
        session.getTransaction().commit();
        session.close();
    }
}
