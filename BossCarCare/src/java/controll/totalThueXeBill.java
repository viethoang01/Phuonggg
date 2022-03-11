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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;
import model.BookingBill;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "totalThueXeBill", urlPatterns = {"/totalthuexebill"})
public class totalThueXeBill extends HttpServlet {

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
        HttpSession session = request.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser != null) {
            Account acc = (Account) objUser;
            request.setAttribute("nav_user", "display: block");  // hiển thị nav user
            request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe   
            request.setAttribute("email_user", acc.getName());
        }
        Object objacc = session.getAttribute("user");
        
        if (objacc != null) {
            response.getWriter().print("hello");
            Account acc = new Account();
            acc = (Account) objacc;
            CarDAO dao = new CarDAO();
            String type = request.getParameter("type");
            response.getWriter().print(acc.getName());

            if (type.equals("thuexe")) {
                ArrayList<Bill> list = null;
                list = dao.getCRI(String.valueOf(acc.getId()));
                if (list != null) {
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("informationBill.jsp").forward(request, response);
                }
            } else {
                ArrayList<BookingBill> list2 = null;
                list2 = dao.getBB(String.valueOf(acc.getId()));
                for (BookingBill bill : list2) {
                    response.getWriter().print(bill.getNameCustomer());
                }
                if (list2 != null) {
                    request.setAttribute("list2", list2);
                    request.getRequestDispatcher("informationBill.jsp").forward(request, response);
                }
            }
        }else{
            response.sendRedirect("EmptyPage.html");
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
