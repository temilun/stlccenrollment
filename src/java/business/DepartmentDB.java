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
public class DepartmentDB {
    public static List<Department> getDepts() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Department> depts;
        
        try {
            session = sessionFactory.openSession();
            Query q = session.createQuery("FROM Department ORDER BY deptName");
            depts = q.list();
        } catch(Exception e) {
            depts = null;
        } finally {
            session.close();
        }
        return depts;
    }
}
