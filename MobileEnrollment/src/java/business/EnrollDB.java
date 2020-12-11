/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jonat
 */
public class EnrollDB {

    public static boolean isRegistered(Enroll enr) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            String qs = "FROM Enroll WHERE crn = :crn AND stuId = :stuId";
            Query q = session.createQuery(qs);
            q.setString("crn", enr.getCrn());
            q.setString("stuId", enr.getStuId());
            if (!q.list().isEmpty()) {
                return true;
            }
        } catch(Exception e) {
            return true;
        } finally {
            if (session != null) {
                session.close();
            }
            
        }
        return false;
    }
    
    public static boolean persistSection (Enroll enr) {
                //grabbing the sessionfactory object from our hibernate utility
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;

        //Adding Enroll object to table
        try {
            //opening the Hibernate session
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(enr);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return true;
    }
    
}
