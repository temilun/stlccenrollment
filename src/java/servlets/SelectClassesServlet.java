package servlets;

import business.Course;
import business.CourseDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: This servlet fetches courses available in specific STLCC Programs
 *              such as "Software Developer" or "Business Administration"
 * @author tom
 */
public class SelectClassesServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //setting default values
        String URL = "/SelectClasses.jsp", msg = "", progID = "";
        List<Course> courses = null;

        try {
            //progID is grabbing the program that the student selected on the
            //EnrollmentHome.jsp webpage
            progID = request.getParameter("progID");
            
            //the "courses" variable calls the getCourses() method in the CourseDB class
            //running the program id we pulled from the webpage in as the parameter
            courses = CourseDB.getCourses(progID);

            if (courses != null) {
                //if courses is not null, push the courses to the session (webpage)                
                request.getSession().setAttribute("courses", courses);
            } else {
                //if null update message to "courses returned null"
                msg = "Courses returned null.";
                URL = "/SelectClasses.jsp";
            }
        } catch(Exception e) {
            msg = "Select Classes servlet error: "+ e.getMessage();
            URL = "/SelectClasses.jsp";
        }

        //set message attribute as the message in case any errors happen
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
