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
        //grabbing the sessionfactory object from our hibernate utility
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        //Creating an empty list for 'Program' objects to be stored
        List<Program> progs;
        
        try {
            //opening the Hibernate session
            session = sessionFactory.openSession();
            
            //Query that selects ALL programs from the program table
            //In HQL to select all from a table, the query is simply:
            //"FROM tablename" instead of SQL's "SELECT * FROM tablename"
            Query q = session.createQuery("FROM Program ORDER BY progName");
            
            //Adding all of our programs to our empty list we created at the
            //beginning of this method
            progs = q.list();
        } catch(Exception e) {
            progs = null;
        } finally {
            //All hibernate sessions must be closed when you are finished
            //Make sure to close the session
            session.close();
        }
        return progs;
    }
}
