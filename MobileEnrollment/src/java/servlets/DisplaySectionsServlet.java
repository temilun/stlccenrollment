/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Course;
import business.CourseDB;
import business.Section;
import business.SectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
public class DisplaySectionsServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "/DisplaySections.jsp", msg ="";
        List<Section> sections = new ArrayList();
        List<Section> sectionsInSearch = null;

        String[] courseIDs;
        List<Course> courses;
        
        /*
            This servlet is currently incomplete.
            Sections always return null in its current state.
            I think it may have something to do with the way the Entity classes
            are designed ( I don't think i quite have the joins correctly set up )
        */
        
        
        try {
            courseIDs = request.getParameterValues("checked");
            
            //if there are sections on session from advanced search, get them
            if (request.getSession().getAttribute("sectionsInSearch") != null) {
                sectionsInSearch = (List<Section>) request.getSession().getAttribute("sectionsInSearch");
                request.getSession().setAttribute("courseIDs", courseIDs);
                
                //for each section in sectionsInSearch,
                //  run through selected courseIDs and see if 
                //  they match. if the courseID matches, add
                //  section to sections to be displayed
                for (Section sec : sectionsInSearch) {
                    for (String id : courseIDs) {
                        if (sec.getCourseId().equals(id)) {
                            sections.add(sec);
                        }
                    }
                }
            } else {
                request.getSession().setAttribute("courseIDs", courseIDs);
                sections = SectionDB.getSections(courseIDs);
            }
            
           
            
            
            if (!sections.isEmpty()) {
                request.getSession().setAttribute("sections", sections);
            } else {
                msg = "Sections returned null";
                URL = "/DisplaySections.jsp";
            }
        } catch(Exception e) {
            msg = "Display Section servlet error: " + e.getMessage();
            URL = "/DisplaySections.jsp";
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
