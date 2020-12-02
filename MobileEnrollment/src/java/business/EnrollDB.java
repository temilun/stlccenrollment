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

    
    public static boolean persistSection (Enroll enr) {
            //grabbing the sessionfactory object from our hibernate utility
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;
    List<Section> sections;
    List<Enroll> existingEnroll;
    boolean dbstat = false;
    
    //Checking to see if section is already in database with this stuid
    try {
        session = sessionFactory.openSession();
        String qs = "from Enroll where crn = :crn and stuId = :stuId";
        Query q = session.createQuery(qs);
        q.setString("crn", enr.getCrn());
        q.setString("stuId", enr.getStuId());
        if (q.list().size() != 0) {
            return false;
        }
        
        } catch(Exception e) {
            System.out.println("EnrollDB data checking error: " + e.getMessage());
        } finally {
            session.close();
        }

        //Adding Enroll object to table
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
