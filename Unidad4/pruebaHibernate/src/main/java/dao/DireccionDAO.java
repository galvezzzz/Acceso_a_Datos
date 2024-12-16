package dao;

import domain.Direccion;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DireccionDAO {
    private SessionFactory sessionFactory;
    private Session session;

    public DireccionDAO() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void listar(){
        String hql = "SELECT d FROM Direccion d";
        Query query = session.createQuery(hql);
        List<Direccion> lstDirecciones = query.getResultList();
        for (Direccion d : lstDirecciones) {
            System.out.println("direccion = " + d);
        }
    }
}
