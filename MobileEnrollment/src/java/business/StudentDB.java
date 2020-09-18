package business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//import javax.persistence.EntityTransaction;

/**
 * @author tom
 */
public class StudentDB {
    public static Student getMemberByID(String stuID){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Student s = em.find(Student.class, stuID);
            return s;
        } finally {
            em.close(); 
        }
    }
    
    
  //   **** This may be useful for registering for classes *****
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
