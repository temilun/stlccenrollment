package servlets;

import business.Enroll;
import business.EnrollDB;
import business.Students;
import business.StudentDB;
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
public class StudentLogonServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msg = "", userid = "";
        String URL = "/Logon.jsp";
        String passatt;
        Students s;
        List<Enroll> schedule;
        
        try {
            userid = request.getParameter("stuId").trim();
            s = StudentDB.getStudent(userid);
            if (s == null){
                msg = "No student record retrieved <br>";
            } else {
                //msg = "Student " + s.getStuFname() + " " + s.getStuLname() + " found.";
                passatt = String.valueOf(request.getParameter("password").trim());
                s.setPassAttempt(passatt);
                if (!s.isAuthenticated()) {
                    msg = "Unable to authenticate";
                } else {
                    schedule = EnrollDB.getSchedule(userid);
                    request.getSession().setAttribute("schedule", schedule);
                    URL = "/StudentHub.jsp";
                    request.getSession().setAttribute("s", s);
                }
            }
        } catch (Exception e) {
            msg = "Exception: " + e.getMessage();
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
