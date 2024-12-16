package com.dam.acdat.dao;

import com.dam.acdat.model.Escritor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EscritoresDao {
    private SessionFactory sessionFactory;

    public EscritoresDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardarEscritor(Escritor escritor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(escritor);
        session.getTransaction().commit();
        session.close();
    }

    public Escritor obtenerEscritorPorId(Long id) {
        Session session = sessionFactory.openSession();
        Escritor escritor = session.get(Escritor.class, id);
        session.close();
        return escritor;
    }

    public void actualizaEscritor(Escritor escritor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(escritor);
        session.getTransaction().commit();
        session.close();
    }

    public void eliminarEscritor(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Escritor escritor = session.get(Escritor.class, id);
        session.delete(escritor);
        session.getTransaction().commit();
        session.close();
    }


    // Método adicional para obtener todos los escritores
    public List<Escritor> obtenerTodosLosEscritores() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT e FROM Escritor e");
        List<Escritor> escritorios = query.list();
        session.close();
        return escritorios;
    }
}
