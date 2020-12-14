/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.CartUtil;
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

/**
 *
 * @author Jonathan Smith
 */
public class CheckoutServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URL = "/Cart.jsp";
        String msg = "";
        Students s = null;
        Enroll enr = null;
        List<Section> secs = null;
        List<Enroll> enrollList = new ArrayList();
        
        try {
            secs = (List<Section>) request.getSession().getAttribute("cartSections");
            s = (Students) request.getSession().getAttribute("s");
            String stuId = s.getStuId();

            
            for (Section i : secs) {
                enr = new Enroll();
                enr.setCrn(i.getCrn());
                enr.setStuId(s.getStuId());
                enr.setEnrollDate(new Date());
                enr.setSection(i);
                enrollList.add(enr);
            }

            for (Enroll e : enrollList) {
                if (EnrollDB.isRegistered(e)) {
                    msg += "You are already enrolled for " + e.getSection().getCourse().getCourseName() + "! <br><br>";
                }
                
                if (!msg.isEmpty()) {
                    msg += "Please fix any cart conflicts and retry.";
                }
            }
            
            if (msg.isEmpty()) {
                if (!CartUtil.checkCartOverlap(secs).equals("")) {
                    msg += CartUtil.checkCartOverlap(secs) + "<br>";
                }
                if (!EnrollDB.isOverlappingDB(secs, s.getStuId()).equals("")) {
                    msg += EnrollDB.isOverlappingDB(secs, stuId);
                }
                
                if (!msg.isEmpty()) {
                    msg += "Please fix any cart conflicts and retry.";
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
                        msg += e.getSection().getCourse().getCourseName() + " Registered!<br><br>"; 
                    } else {
                        msg += "Error registering for " + e.getSection().getCourse().getCourseName() + ".<br>";
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
