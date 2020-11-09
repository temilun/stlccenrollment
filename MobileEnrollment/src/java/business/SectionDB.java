/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sun.util.logging.resources.logging;

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
        
        List<Section> sections = new ArrayList();
        
       
        
        try {
            //opening the hibernate section
            session = sessionFactory.openSession();
            
            //checking 
            
            
//            for (String id : courseId) {
//                String qs = "FROM Course WHERE courseId = :id";
//                Query q = session.createQuery(id);
//                q.setString("id", id);
//                sections.add((Course) q.uniqueResult());
//            }
            
//            for (String id : courseId) {
//                String qs = "FROM Course WHERE courseId = :id";
//                Query q = session.createQuery(qs);
//                q.setString("id", id);
//                System.out.println(q.setString("id", id));
//            }

            
            String qs = "from Section where course.courseId = :id";
            for (String id : courseId) {
                Query q = session.createQuery(qs);
                q.setString("id", id);
                sections.addAll(q.list());
            }
            
            
//            q.setString("id", courseId[0]);
            
            
//            sections = (Section) q.uniqueResult();
            
            
//            String qs = "FROM Course WHERE courseId = :ids";
//            Query q = session.createQuery(qs).setParameterList("ids", Arrays.asList(courseId));
//            sections = q.list();
            
            //for each course ID in array of IDs, run the HQL statement to get
            //the relevant sections available and add them to our section list
//            for (String id : courseId) {
//                System.out.println(id);
//                String qs = "FROM Course WHERE courseId = :id"; 
//                Query q = session.createQuery(qs);
//                q.setString("id", id);
//                System.out.println(q.uniqueResult());
//            }
        } catch(Exception e) {
            sections = null;
            System.out.println("SectionDB error: " + e.getMessage());
        } finally {
            //All hibernate sessions must be closed when you are finished
            //Make sure to close the session
            session.close();
        }
        return sections;
    }
}
