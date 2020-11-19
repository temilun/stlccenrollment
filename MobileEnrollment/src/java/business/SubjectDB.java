/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Course;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tom
 */
public class SubjectDB {
    
    public static List<String> getSubjects() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
    
        //creating an list of courses to pull subjects from
        List<Course> courses = new ArrayList();
        //subjects will be parsed from courses list and put into this list
        List<String> subjects = new ArrayList();
        
        try {
            session = sessionFactory.openSession();
            //querying all courses from the database
            Query q = session.createQuery("FROM Course");
            //putting all queried courses into our courses list
            courses = q.list();
            
            
            //for each course in our courses list, add the course subject if
            //      it is not already in the subject list
            for (Course course : courses) {
                if (!subjects.contains(course.getCourseSub())) {
                    subjects.add(course.getCourseSub());
                }
            }
        } catch(Exception e) {
            subjects = null;
        } finally {
            session.close();
        }
        return subjects;
    }
    
    
}
