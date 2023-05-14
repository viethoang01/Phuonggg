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
import model.Bill;
import model.BookingBill;
import model.Car;
import model.CarRentalInvoice;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        CarDAO dao = new CarDAO();
        Account acc = null;
        String email = request.getParameter("email_login").trim();
        String pass = request.getParameter("pass_login").trim();
        if (email.equals("Admin") && pass.equals("Admin")) {
            ArrayList<Account> list = dao.ListAcc();

            for (Account account : list) {
                if (account.getName().equals(email)) {

                    if (account.getPassword().equals(pass)) {

                        acc = account;
                        break;
                    }

                }
            }
            response.getWriter().print("hello");
            HttpSession session = request.getSession();
            session.setAttribute("user", acc);
            response.sendRedirect("home");
        } else {
            boolean checkEmail = email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            request.setAttribute("email_login_value", email);
            if (!checkEmail) {
                request.setAttribute("email_err1", "block");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            if (pass.trim().equals("")) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            ArrayList<Account> list = dao.ListAcc();
            boolean valiablePass = false;

            for (Account account : list) {
                if (account.getName().equals(email)) {

                    if (account.getPassword().equals(pass)) {
                        valiablePass = true;
                        acc = account;

                    }
                    break;
                }
            }

            if (!valiablePass) {
                request.setAttribute("acc_err", "block");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_email = new Cookie("email", email);
                response.addCookie(c_email);

                c_email.setMaxAge(60);

            }

            HttpSession session = request.getSession();
            session.setAttribute("user", acc);
            Object objthuexe = session.getAttribute("loginReturn");
            Object objbaoduong = session.getAttribute("loginandbb");
            if (objthuexe != null) {
                Object obj = session.getAttribute("bill");
                if (obj != null) {
                    Bill bill = (Bill) obj;
                    bill.setAccId(String.valueOf(acc.getId()));         // set account id 
                    session.setAttribute("bill", bill);
                    response.sendRedirect("xacnhan");
                } else {
                    response.getWriter().print("bill null");
                }

            } else if (objbaoduong != null) {
                Object bookingbillobj = session.getAttribute("bookingbill");
                response.getWriter().print(bookingbillobj != null);
                if (bookingbillobj != null) {
                    BookingBill bookingBill = (BookingBill) bookingbillobj;
                    bookingBill.setAccId(String.valueOf(acc.getId()));
                    session.setAttribute("bookingbill", bookingBill);
                    response.sendRedirect("xacnhanBookingBill");

                } else {
                    response.getWriter().print("bill null");
                }
            } else {
                response.sendRedirect("home");
            }
        }

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
