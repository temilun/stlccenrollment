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
public class CampusDB {
    public static List<Campus> getCampuses() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Campus> campuses;
        
        try {
            session = sessionFactory.openSession();
            Query q = session.getNamedQuery("Campus.findAll");
            campuses = q.list();
        } catch (Exception e) {
            campuses = null;
        } finally {
            session.close();
        }
        return campuses;
    }
}
