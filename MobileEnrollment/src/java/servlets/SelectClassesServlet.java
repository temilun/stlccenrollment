package servlets;

import business.AdvSearchDB;
import business.Course;
import business.CourseDB;
import business.Section;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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
        String URL = "/SelectClasses.jsp", msg = "";
        String searchType = "";
        String progID = "";
        List<Course> courses = new ArrayList();
        List<Section> sectionsInSearch;
        
        
        if (request.getSession().getAttribute("sectionsInSearch") != null) {
            request.getSession().removeAttribute("sectionsInSearch");
        }
        //grabbing search type (search by program or advanced search)
        try {
            searchType = request.getParameter("searchType");
        } catch (Exception e) {
            msg = "Error on getting search type.";
        }
        
        if (searchType != null && searchType.equals("progSearch")) {
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
                msg = "Program search error: "+ e.getMessage();
                URL = "./EnrollmentHome.jsp";
            }
        } else if (searchType != null && searchType.equals("advSearch")) {
            try {
                String subject;
                String startTime = "", endTime = "";
                Date start = null, end = null;
                String campusId;
                String termType, classType;
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                
                subject = request.getParameter("course_subject");
                startTime = request.getParameter("startTime");
                if (!startTime.isEmpty()) {
                    start = sdf.parse(startTime);
                }
                endTime = request.getParameter("endTime");  
                if (!endTime.isEmpty()) {
                    end = sdf.parse(endTime);
                } else {
                    
                }
                campusId = request.getParameter("campus");
                termType = request.getParameter("termType");
                classType = request.getParameter("classType");
                
                
                sectionsInSearch = AdvSearchDB.getSectionsAdv(subject, start, end, campusId, termType, classType);
                //putting search results on session to access after class selection
                request.getSession().setAttribute("sectionsInSearch", sectionsInSearch);
                
                
                for (Section sec : sectionsInSearch ) {
                    if (!courses.contains(sec.getCourse())) {
                        courses.add(sec.getCourse());
                    }
                }
                
                if (!courses.isEmpty()) {
                    request.getSession().setAttribute("courses", courses);
                } else {
                    msg = "No courses found for your search! Try again with different search parameters";
                    URL = "/EnrollmentHome.jsp";
                }
            } catch (Exception e) {
                msg = "Adv Search error: " + e.getMessage();
                URL = "/EnrollmentHome.jsp";
            }
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
