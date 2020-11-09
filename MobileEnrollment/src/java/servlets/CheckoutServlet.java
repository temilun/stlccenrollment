<<<<<<< HEAD

package servlets;

import cart.Billing;
import cart.Shipping;
import cart.ShoppingCart;
import cart.ShoppingCartException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
=======
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
>>>>>>> 8ce115025231e5d8035902a9d1da0b636d3467e8
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;


=======
>>>>>>> 8ce115025231e5d8035902a9d1da0b636d3467e8

/**
 *
 * @author jonat
 */
public class CheckoutServlet extends HttpServlet {
<<<<<<< HEAD
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {
        // First get the shipping values from the request.
        Shipping shipping = new Shipping();

        shipping.setName(request.getParameter("name"));
        shipping.setAddress1(request.getParameter("address1"));
        shipping.setAddress2(request.getParameter("address2"));
        shipping.setCity(request.getParameter("city"));
        shipping.setState(request.getParameter("state"));
        shipping.setPostalCode(request.getParameter("postalCode"));
        shipping.setCountry(request.getParameter("country"));
        shipping.setEmail(request.getParameter("email"));

// Next, get the billing values.
        Billing billing = new Billing();

        billing.setNameOnCard(request.getParameter("nameOnCard"));
        billing.setCreditCardType(request.getParameter("creditCardType"));
        billing.setCreditCardNumber(request.getParameter(
            "creditCardNumber"));
        billing.setCreditCardExpiration(request.getParameter(
            "creditCardExpiration"));

        HttpSession session = request.getSession();

// Get the cart.
        ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");

// If there is no shopping cart, create one (this should really be an error).
        if (cart == null)
        {
            cart = new ShoppingCart();

            session.setAttribute("ShoppingCart", cart);
        }

        try
        {
            String confirmation = cart.completeOrder(shipping, billing);

// Now display the cart and allow the user to check out or order more courses.
            response.sendRedirect(response.encodeRedirectURL(
                "/shoppingcart/ShowConfirmation.jsp"+
                "?confirmationNumber="+URLEncoder.encode(confirmation)));
        }
        catch (ShoppingCartException exc)
        {
            PrintWriter out = response.getWriter();

            out.println("<html><body><h1>Error</h1>");
            out.println("The following error occurred while processing your order:");
            out.println("<pre>");
            out.println(exc.getMessage());
            out.println("</pre>");
            out.println("</body></html>");
            return;
        }
    
    }
=======

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
            
            for (Section i : secs) {
                enr = new Enroll();
                enr.setCrn(i.getCrn());
                enr.setStuId(s.getStuId());
                enr.setEnrollDate(new Date());
                enrollList.add(enr);
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

>>>>>>> 8ce115025231e5d8035902a9d1da0b636d3467e8
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
