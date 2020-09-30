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
public class SectionDB {
    public static List<Section> getSections(String[] courseId) {
        //getting sessionfactory from our hibernate utility
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //initializing the session object
        Session session = null;
        
        List<Section> sections = null;
       
        
        try {
            //opening the hibernate section
            session = sessionFactory.openSession();
            
            //for each course ID in array of IDs, run the HQL statement to get
            //the relevant sections available and add them to our section list
            for (String id : courseId) {
                String qs = "FROM Section WHERE courseId = :id"; 
                Query q = session.createQuery(qs);
                q.setString("id", id);
                sections.addAll(q.list());
            }
        } catch(Exception e) {
            sections = null;
        } finally {
            //All hibernate sessions must be closed when you are finished
            //Make sure to close the session
            session.close();
        }
        return sections;
    }
}
