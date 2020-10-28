/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jonat
 */
public class EnrollDB {

    
    public static boolean persistSection (Enroll enr) {
            //grabbing the sessionfactory object from our hibernate utility
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;
    List<Section> sections;
    
    boolean dbstat = false;
    
    try {
        //opening the Hibernate session
        session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(enr);
        session.getTransaction().commit();
        dbstat = true;
    } catch (Exception e) {
        if (session != null) {
            session.getTransaction().rollback();
        }
    } finally {
        session.close();
    }
    return dbstat;
}
    
}
