package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import javax.persistence.EntityTransaction;

/**
 * @author tom
 */
public class StudentDB {
    
// ***** Old version of connecting to db with EclipseLink ******
//    public static Students getStudentByID(String stuID){
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        try {
//            Students s = em.find(Students.class, stuID);
//            return s;
//        } finally {
//            em.close(); 
//        }
//    }
    
    public static Students getStudent(String stuID) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Students s = null;
        
        try {
            session = sessionFactory.openSession();
            String qs = "from Students where stuId = :stuID";
            Query q = session.createQuery(qs);
            
            q.setString("stuID", stuID);
            s = (Students) q.uniqueResult();
        } catch (Exception e) {
            s = null;
            System.out.println("Error on getting student : " + e.getMessage());
        } finally {
            session.close();
        }
        return s;
    }
    
    
  //   **** This may be useful for registering for classes *****
  //   ***** not updated for hibernate - this was made with eclipselink ******** 
//    public static String updtMember(Student s) {
//        String msg = "";
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        EntityTransaction trans = em.getTransaction();
//        try {
//            trans.begin();
//            em.merge(m);
//            trans.commit();
//            msg = "Student " + m.getID() + " updated<br>";
//        } catch(Exception e) {
//            msg = "Error on member update: " + e.getMessage();
//            trans.rollback();
//        } finally {
//            em.close();
//        }
//        return msg;
//    }
}
