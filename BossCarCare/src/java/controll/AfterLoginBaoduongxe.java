/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.BookingBill;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AfterLoginBaoduongxe", urlPatterns = {"/afterLoginBaoduongxe"})
public class AfterLoginBaoduongxe extends HttpServlet {

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
        HttpSession session = request.getSession();
        Object objacc = session.getAttribute("user");
        Account acc = null;
        if (objacc != null) {
            acc = (Account) objacc;
            Object accessBB = session.getAttribute("loginandbb");       // xac nhan booking
            response.getWriter().print(accessBB != null);
//        String access = (String) accessBB
            if (accessBB != null) {

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

            }
        }

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
