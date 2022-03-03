/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "XacnhanServlet", urlPatterns = {"/xacnhan"})
public class XacnhanServlet extends HttpServlet {

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
        String Carid =(String) request.getAttribute("Carid");
        String Accid =(String) request.getAttribute("Accid");
        String thoiluongthue =(String) request.getAttribute("thoiluongthue");
        String customer_type =(String) request.getAttribute("customer_type");
        String name_customer =(String) request.getAttribute("name_customer");
        String CMND_customer =(String) request.getAttribute("CMND_customer");
        String phone_customer =(String) request.getAttribute("phone_customer");
        String email_customer =(String) request.getAttribute("email_customer");
        String gioithieu_code_customer =(String) request.getAttribute("gioithieu_code_customer");
        String startdayString =(String) request.getAttribute("startdayString");
        String endday =(String) request.getAttribute("endday");
        double totalmoney =(double) request.getAttribute("totalmoney");
        
        CarDAO dao = new CarDAO();
        dao.InsertRental
        (Carid, Accid, thoiluongthue, customer_type, name_customer, CMND_customer, phone_customer, email_customer, gioithieu_code_customer, startdayString, endday, String.valueOf(totalmoney));
        response.sendRedirect("home");
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
