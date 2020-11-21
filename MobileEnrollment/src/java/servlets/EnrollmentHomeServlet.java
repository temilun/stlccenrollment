/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Department;
import business.DepartmentDB;
import business.Program;
import business.ProgramDB;
import business.SubjectDB;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EnrollmentHomeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //initializes starting variables
        String URL = "/EnrollmentHome.jsp", msg = "";
        
        //This is where the list of programs is stored
        List<Program> progs;
        List<String> subjects;
        
        request.getSession().setAttribute("sectionsInSearch", null);
        
        try {
            //progs = list of all programs from the database
            progs = ProgramDB.getPrograms();
            subjects = SubjectDB.getSubjects();
            if (progs == null) {
                msg = "Programs or subjects returned null. <br>";
                URL = "/StudentHub.jsp";
            } else {
                //if progs is not null, set the session attribute of "progs"
                //  to our list of programs
                request.getSession().setAttribute("progs", progs);
                request.getSession().setAttribute("subjects", subjects);
            }
        } catch(Exception e) {
            msg = "Enrollment Home Servlet Error: " + e.getMessage();
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
