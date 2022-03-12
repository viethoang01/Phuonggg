/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Car;
import model.Message;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
        CarDAO cd = new CarDAO();
        ArrayList<Car> list = cd.getAll();
        request.setAttribute("listcar", list); // get list car
        String email = "";
        HttpSession session = request.getSession();
        Object objAcc = session.getAttribute("user");
        Account acc = null;
        if (objAcc != null) {
            acc = (Account) objAcc;

            email = acc.getName();

        }
        if (email.equals("")) {
            Cookie[] cookie = request.getCookies();
            if (cookie != null) {
                for (Cookie cookie1 : cookie) {
                    if (cookie1.getName().equals("email")) {

                        email = cookie1.getValue();

                        Account accountgetbycookie = cd.getAcc(email);
                        session.setAttribute("user", accountgetbycookie);
                    }

                }

            }
        }
        if (email.equals("") && acc == null) {                       //  mặc định
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {

        }

        if (!email.equals("") && !email.equals("Admin")) {

            CarDAO dao = new CarDAO();
            ArrayList<Message> MessageYouReceive = dao.getAllMessageofUser(String.valueOf(acc.getId()), "45");     /// list message
            ArrayList<Message> MessageYouSend = dao.getAllMessageofUser("45", String.valueOf(acc.getId()));
            request.setAttribute("MYR", MessageYouReceive);
            request.setAttribute("MYS", MessageYouSend);

            request.setAttribute("nav_user", "display: block");  // hiển thị nav user
            request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe 

            request.setAttribute("email_user", email);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        if (email.equals("Admin")) {
            String Customerid = request.getParameter("Customerid");
            if (Customerid.equals("")) {
                request.setAttribute("messageAdmin", "block");
                request.setAttribute("messageadmin", "none");
            } else {
                CarDAO dao = new CarDAO();
                ArrayList<Message> MessageYouSend = dao.getAllMessageofUser(Customerid, "45");     /// list message
                ArrayList<Message>  MessageYouReceive = dao.getAllMessageofUser("45", Customerid);
                request.setAttribute("MYR", MessageYouReceive);
                request.setAttribute("MYS", MessageYouSend);
            }
            request.setAttribute("manage", "display: block");
            request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe 

            request.setAttribute("email_user", email);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
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
