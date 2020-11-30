/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
            
            //if subject is not null, find sections with the course subject of <subject>
            if (subjects != null) {
                for (String subject : subjects) {
                    criteria.add(Restrictions.like("course.courseSub", subject));
                }
            }
            if (start != null) {
                //Date start = sdf.parse(startTime);
                criteria.add(Restrictions.like("startTime", start));
            }
            if (end != null) {
                criteria.add(Restrictions.like("endTime", end));
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
