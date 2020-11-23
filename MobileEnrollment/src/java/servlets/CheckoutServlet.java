/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Enroll;
import business.EnrollDB;
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
 * @author jonat
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
            
            //this should check if any classes in cart happen at the exact same time. additional checking is needed.
            for (int j = 0; j < secs.size() - 1; j++) {
                for (int k = j + 1; k < secs.size(); k++) {
                    if (secs.get(j).getDays().equals(secs.get(k).getDays())) {
                        if (secs.get(j).getStartTime().equals(secs.get(k).getStartTime())) {
                            msg += secs.get(j).getCrn() + " occurs at the same time as " + secs.get(k).getCrn() + "<br>";
                            URL = "/Cart.jsp";
                        }
                    }
                }
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
