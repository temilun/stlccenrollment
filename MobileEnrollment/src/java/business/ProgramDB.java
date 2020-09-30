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
 * @author tom
 */
public class ProgramDB {
    
    public static List<Program> getPrograms() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Program> progs;
        
        try {
            session = sessionFactory.openSession();
            Query q = session.createQuery("FROM Program ORDER BY progName");
            progs = q.list();
        } catch(Exception e) {
            progs = null;
        } finally {
            session.close();
        }
        return progs;
    }
}
