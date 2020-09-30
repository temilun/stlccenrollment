package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author tom
 * Description: Searches through database to find student based on userID
 */
public class StudentDB {    
    public static Students getStudent(String stuID) {
        //Get sessionFactory from hibernateutil class
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        //initializing our student of type "Students"
        Students s = null;
        
        try {
            //opens the hibernate session
            session = sessionFactory.openSession();
            
            //creating our query - the ":stuID" part of the query is set as
            //  userID variable from the StudentLogonServlet. Adding the ":" in front
            //  of a section of the query allows you to set the variable of the query
            //  every time you call the method
            String qs = "from Students where stuId = :stuID";
            
            //creating a query for our String we just made
            Query q = session.createQuery(qs);
            
            //setting the query ":stuID" with our stuID variable that is passed
            //  into the getStudent() method
            q.setString("stuID", stuID);
            
            //if a unique result is found for the student ID passed into the method,
            //  our student object is filled.
            //  the "uniqueResult()" method finds a single match for the query
            s = (Students) q.uniqueResult();
        } catch (Exception e) {
            s = null;
            System.out.println("Error on getting student : " + e.getMessage());
        } finally {
            //The query is done running,
            //time to close the hibernate session
            session.close();
        }
        return s;
    }
}
