/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jonat
 */
public class EnrollDB {

    public static boolean isRegistered(Enroll enr) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        
        try {
            session = sessionFactory.openSession();
            String qs = "FROM Enroll WHERE crn = :crn AND stuId = :stuId";
            Query q = session.createQuery(qs);
            q.setString("crn", enr.getCrn());
            q.setString("stuId", enr.getStuId());
            if (!q.list().isEmpty()) {
                return true;
            }
        } catch(Exception e) {
            return true;
        } finally {
            if (session != null) {
                session.close();
            }
            
        }
        return false;
    }
    
    //Jon's method to check to see if classes in cart are overlapping with
    //  classes in the database
    public static String isOverlappingDB(List<Section> secs, String stu_id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        String msg = "";
        List<Enroll> enrolled;
        
        try {
            session = sessionFactory.openSession();
            String qs = "from Enroll where stuId = :stuId";
            Query q = session.createQuery(qs);
            q.setString("stuId", stu_id);

            enrolled = q.list();

            if (enrolled != null) {
                for (int j = 0; j < secs.size(); j++) {
                        if (secs.get(j).getDays()!= null) {
                                for (int k = 0; k < enrolled.size(); k++) {
                                    if (enrolled.get(k).getSection().getDays() != null) {
                                    char[] days1 = secs.get(j).getDays().toCharArray();
                                    char[] days2 = enrolled.get(k).getSection().getDays().toCharArray();

                                    //Labeling this loop to break after the condition is met once
                                    //  so the message doesn't fill in for each day of the classes
                                    innerLoop:
                                    for (char c:days1) {
                                        for (char c2:days2) {
                                            if (c == c2) {
                                                if (isOverlapping(secs.get(j).getStartTime(), secs.get(j).getEndTime(), enrolled.get(k).getSection().getStartTime(), enrolled.get(k).getSection().getEndTime())) {
                                                    msg += secs.get(j).getCourse().getCourseName() + " occurs at the same time as your previously enrolled class, " + enrolled.get(k).getCrn() + " " + enrolled.get(k).getSection().getCourse().getCourseName() + "<br><br>";
                                                    break innerLoop;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch(Exception e) {
                msg = "CheckoutServlet data checking error: " + e.getMessage();
                System.out.println("EnrollDB data checking error: " + e.getMessage());
            } finally {
                session.close();
            }
        return msg;
    }
    
    public static boolean persistSection (Enroll enr) {
        //grabbing the sessionfactory object from our hibernate utility
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;

        //Adding Enroll object to table
        try {
            //opening the Hibernate session
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(enr);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return true;
    }
    
    
    //Jon's isOverlapping method
    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }
}
