/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Enroll;
import business.EnrollDB;
import business.HibernateUtil;
import business.Section;
import business.Students;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jonathan Smith
 */
public class CheckoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URL = "/Cart.jsp";
        String msg = "";
        Students s = new Students();
        Enroll enr = new Enroll();
        List<Section> secs = null;
        List<Enroll> enrollList = new ArrayList();
        
        
        
        try {
            secs = (List<Section>)request.getSession().getAttribute("cartSections");
            s = (Students)request.getSession().getAttribute("s");
            String stu_id = s.getStuId();

            
            //Jon's cart date/time validation
            //this should check if any classes in the cart happen at the same time
            for (int j = 0; j < secs.size() - 1; j++) {
                for (int k = j + 1; k < secs.size(); k++) {
                    
                    char[] days1 = secs.get(j).getDays().toCharArray();
                    char[] days2 = secs.get(k).getDays().toCharArray();
                    
                    for (char c:days1) {
                        for (char c2:days2) {
                            if (c == c2) {
                                if (isOverlapping(secs.get(j).getStartTime(), secs.get(j).getEndTime(), secs.get(k).getStartTime(), secs.get(k).getEndTime())) {
                                    msg += secs.get(j).getCrn() + " " + secs.get(j).getCourse().getCourseName() + " occurs at the same time as " + secs.get(k).getCrn() + " " + secs.get(k).getCourse().getCourseName() + "<br>";
                                    URL = "/Cart.jsp";
                                }
                            }
                        }
                    }
                }
            }
            
            //Jon's date/time validation with the database
            //this compares classes in the cart to already-registered classes
            //grabbing the sessionfactory object from our hibernate utility
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = null;
            List<Section> sections;
            List<Enroll> enrolled;

            try {
                session = sessionFactory.openSession();
                String qs = "from Enroll where stuId = :stuId";
                Query q = session.createQuery(qs);
                q.setString("stuId", stu_id);
                
                enrolled = q.list();
                
                if (enrolled != null) {
                       
                       
                    for (int j = 0; j < secs.size(); j++) {
                        for (int k = 0; k < enrolled.size(); k++) {
                        
                            char[] days1 = secs.get(j).getDays().toCharArray();
                            char[] days2 = enrolled.get(k).getSection().getDays().toCharArray();
                            
                            for (char c:days1) {
                                for (char c2:days2) {
                                    if (c == c2) {
                                        if (isOverlapping(secs.get(j).getStartTime(), secs.get(j).getEndTime(), enrolled.get(k).getSection().getStartTime(), enrolled.get(k).getSection().getEndTime())) {
                                            msg += secs.get(j).getCrn() + " " + secs.get(j).getCourse().getCourseName() + " occurs at the same time as your previously enrolled class, " + enrolled.get(k).getCrn() + " " + enrolled.get(k).getSection().getCourse().getCourseName() + "<br>";
                                            URL = "/Cart.jsp";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch(Exception e) {
                msg = "EnrollDB data checking error: " + e.getMessage();
                System.out.println("EnrollDB data checking error: " + e.getMessage());
            } finally {
                session.close();
            }
            
            
            if (msg.isEmpty()) {
                for (Section i : secs) {
                    enr = new Enroll();
                    enr.setCrn(i.getCrn());
                    enr.setStuId(s.getStuId());
                    enr.setEnrollDate(new Date());
                    enrollList.add(enr);
                }
            }
        
        } catch (Exception e) {
            msg += "Error on Checkout Servlet: " + e.getMessage();
        }
        
        try {
            if (msg.isEmpty()) {
                for (Enroll e : enrollList) {
                    boolean enrAdded = EnrollDB.persistSection(e);
                    if (enrAdded) {
                        msg += "CRN " + e.getCrn() + " Registered.<br>"; 
                    } else {
                        msg += "Already registered for CRN " + e.getCrn() + ".<br>";
                    }
                }
                request.getSession().setAttribute("enrollList", enrollList);
                
                URL = "/StudentHub.jsp";
                request.getSession().setAttribute("cartSections", new ArrayList());
            } 
        } catch (Exception e) {
            msg += "CheckOutServlet Error: " + e.getMessage() + "<br>";
        }
        
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);        
        
    }
    
    
    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
