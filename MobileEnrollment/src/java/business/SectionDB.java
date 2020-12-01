/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
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
        List<Section> sections = new ArrayList();
        
        try {
            //opening the hibernate section
            session = sessionFactory.openSession();
            
           
            String qs = "from Section where course.courseId = :id";
            for (String id : courseId) {
                Query q = session.createQuery(qs);
                q.setString("id", id);
                sections.addAll(q.list());
            }
            
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
    
    public static List<Section> getSectionsByCRN(List<String> CRNs) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Section> sections = new ArrayList();
        
        try {
            session = sessionFactory.openSession();
            String qs = "FROM Section WHERE crn = :crn";
            for (String crn : CRNs) {
                Query q = session.createQuery(qs);
                q.setString("crn", crn);
                sections.add((Section) q.uniqueResult());
            }
        } catch (Exception e) {
            sections = null;
            System.out.println("SectionDB error: " + e.getMessage());
        } finally {
            session.close();
        }
        return sections;
    }    
}
