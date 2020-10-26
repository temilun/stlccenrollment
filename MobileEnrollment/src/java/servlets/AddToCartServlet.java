/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Section;
import business.SectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tom
 */
public class AddToCartServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String URL="/Cart.jsp", msg = "";
        List<Section> sections = null;
        List<String> CRNs = new ArrayList();
        String[] courseIDs;
            
        
        try {
            courseIDs = (String[]) request.getSession().getAttribute("courseIDs");
            for (String id : courseIDs) {
                String crn = request.getParameter(id);
                if (crn != null) {
                    CRNs.add(crn);
                }    
            }

            List<Section> existingSections = (List<Section>) request.getSession().getAttribute("cartSections");
            
            if (existingSections == null) {
                sections = SectionDB.getSectionsByCRN(CRNs);
            } else {
                sections = SectionDB.getSectionsByCRN(CRNs);
                sections.addAll(existingSections);
            }
            
//            for ( Section section : sections ) {
//                
//            }
            
            if ( sections != null ) {
                request.getSession().setAttribute("cartSections", sections);
            } else {
                msg += "AddToCart Servlet Error: sections returned null";
                URL = "/StudentHub.jsp";
            }
            
        } catch (Exception e) {
            msg += "AddToCart Servlet Error: " + e.getMessage();
            URL = "/StudentHub.jsp";
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
