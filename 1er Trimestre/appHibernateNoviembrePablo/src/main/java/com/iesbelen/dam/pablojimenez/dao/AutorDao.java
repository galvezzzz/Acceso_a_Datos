package com.iesbelen.dam.pablojimenez.dao;

import com.iesbelen.dam.pablojimenez.model.Autor;
import com.iesbelen.dam.pablojimenez.model.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDao {
    private SessionFactory sessionFactory;

    public AutorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardarAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(autor);
        session.getTransaction().commit();
        session.close();
    }

    public Autor obtenerAutorPorId(Long id) {
        Session session = sessionFactory.openSession();
        Autor autor = session.get(Autor.class, id);
        session.close();
        return autor;
    }

    public void actualizarAutor(Autor autor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(autor);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarAutor(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, id);
        session.delete(autor);
        session.getTransaction().commit();
        session.close();
    }


    // Método adicional para obtener todos los autores
    public List<Autor> obtenerTodosLosAutores() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT a FROM Autor a");
        List<Autor> autores = query.list();
        session.close();
        return autores;
    }
}
