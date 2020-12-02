/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author tom
 */
public class AdvSearchDB {
    public static List<Section> getSectionsAdv(String[] subjects, Date start, Date end, String campusId, String termType, String classType) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        List<Section> sections;
        List<Course> courses = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            session = sessionFactory.openSession();
            //creating query with the Criteria API
            Criteria criteria = session.createCriteria(Section.class);
            //creating a criteria alias to access nested Course object
            criteria.createAlias("course", "course");
            criteria.createAlias("campus", "campus");
            
            // --- Creating a query with the Criteria API in Hibernate ---
            //
            // - We are using the Criteria API because we need to create dynamic
            //   queries for the advanced search feature.
            // - For each of the search parameters, we check to see if it is
            //   not null (left blank on the form).
            // - If the parameter is not null, we add the criteria to our
            //   Criteria object.
            //
            // - For more on creating queries with the Criteria API see:
            //   https://docs.jboss.org/hibernate/core/3.3/reference/en-US/html/querycriteria.html
            
            if (subjects != null) {
                criteria.add(Restrictions.in("course.courseSub", subjects));
            }
            if (start != null) {
                criteria.add(Restrictions.like("startTime", start));
            }
            if (end != null) {
                criteria.add(Restrictions.like("endTime", end));
            }
            if (campusId != null) {
                criteria.add(Restrictions.like("campus.campId", campusId));
            }
            if (termType != null) {
                criteria.add(Restrictions.like("termType", termType));
            }
            if (classType != null) {
                criteria.add(Restrictions.like("secType", classType));
            }
            
            sections = criteria.list();
        } catch (Exception e) {
            sections = null;
        } finally {
            session.close();
        }
        return sections;
    }
}
