/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import business.Course;
import business.HibernateUtil;
import java.util.Enumeration;
import java.util.Vector;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jonathan
 */
public class ShoppingCart implements java.io.Serializable{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = null;
    
// The shopping cart courses are stored in a Vector.
    protected static Vector courses;

    public static void ShoppingCart()
    {
        courses = new Vector();
    }

// Returns a (clone) Vector containing the courses in the cart.
    public Vector getCourses()
    {
        return (Vector) courses.clone();
    }

    public synchronized static void addCourse(Course newCourse)

    {
        courses.addElement(newCourse);
    }

    public synchronized static void removeCourse(int courseIndex)

    {
        courses.removeElementAt(courseIndex);
    }

    protected static int nextOrderNumber = 1;

// Submit the order and return a confirmation number.
    public String completeOrder(Shipping shipping, Billing billing)
        throws ShoppingCartException
    {

//Write to Enroll table in DB here
        try
        {
            int orderNumber = 0;

// Make sure no other threads can be generating an order number.
            synchronized (this)
            {
                orderNumber = nextOrderNumber;
                nextOrderNumber = nextOrderNumber + 1;
            }

//Send to EnrollDB to save in database
            Enumeration e = courses.elements();
            while (e.hasMoreElements())
            {
                session = sessionFactory.openSession();
                Course course = (Course) e.nextElement();

                
                //the mysql INSERT statement
                String qs = "INSERT INTO Enroll " + "VALUES (Section.crn, session.stu_id, CURDATE(), orderNumber)";
                Query q = session.createQuery(qs);
                
            }
// Return a confirmation number (the order number as a string in this case).
            return ""+orderNumber;
        }
        catch (Exception exc)
        {
            throw new ShoppingCartException(
                "Error saving order: "+exc.toString());
        } finally {
            session.close();
        }
    }
}
