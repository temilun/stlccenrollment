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
public class CourseDB {
    public static List<Course> getCourses(String programID) {
        
        //grabbing the sessionfactory object from our hibernate utility
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = null;
        
        //course objects will be stored here
        List<Course> courses;
        
        try {
            //Opening the Hibernate session
            session = sessionFactory.openSession();
            
            //This query will select courses where the program ID is = to what 
            //is selected from the dropdown menu on
            //EnrollmentHome.jsp OR if the course is listed under general studies
            //(program id 3 is general studies)
            //(may be temporary while we figure out a solution for showing genera studies
            //along with 'Program' specific courses)
            String qs = "FROM Course WHERE (progId = :programID OR progId = '3') ORDER BY course_name";
            
            //creates query from the String we made above
            Query q = session.createQuery(qs);
            
            //setting the query string parameter ':programID' as the programID
            //parameter that was passed into the method
            q.setString("programID", programID);
            
            //This is us assigning the list of queried objects to the courses var
            courses = q.list();
        } catch (Exception e) {
            //if any problems happen, courses will return null
            courses = null;
        } finally {
            //All hibernate sessions must be closed when you are finished
            //Make sure to close the session
            session.close();
        }
        return courses;
    }
}
