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
import javax.servlet.http.HttpSession;
import model.Account;
import model.Bill;
import model.CarRentalInvoice;

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
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("doget");
        HttpSession session = request.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser !=null){
            Account acc = (Account) objUser;
            request.setAttribute("nav_user", "display: block");  // hiển thị nav user
            request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe   
            request.setAttribute("email_user", acc.getName());
        }
        
        Object obj = session.getAttribute("bill");
        session.setAttribute("billid", "billid");
        if(obj != null){
            Bill bill = (Bill) obj;
            

            request.setAttribute("Carid", bill.getCarId());
            request.setAttribute("Accid", bill.getAccId());
            request.setAttribute("songaythue", bill.getThoiluong());
            request.setAttribute("donvithue", bill.getDonvi());
            request.setAttribute("name_customer", bill.getNameCustomer());
            request.setAttribute("CMND_customer", bill.getCMND());
            request.setAttribute("phone_customer", bill.getPhone());
            request.setAttribute("email_customer", bill.getEmail());
            request.setAttribute("gioithieu_code_customer", bill.getCode_inv());
            request.setAttribute("startdayString", bill.getStartday());
            request.setAttribute("endday", bill.getEndday());
            request.setAttribute("totalmoney", bill.getTotal());
            request.setAttribute("price", bill.getPrice());
            request.getRequestDispatcher("xacnhan.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("EmptyPage.html").forward(request, response);
        
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
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("bill");
        if(obj != null){
            Bill bill = (Bill) obj;
            CarRentalInvoice CRI = new CarRentalInvoice();
            CRI.addBill(bill.getAccId(), bill);     // 1 acc có thể có nhiều bill
            
            CarDAO dao = new CarDAO();
            dao.InsertRental
            (bill.getCarId(), bill.getAccId(), bill.getThoiluong(), bill.getDonvi(), bill.getNameCustomer(),bill.getCMND(), bill.getPhone(), bill.getEmail(), bill.getCode_inv(), bill.getStartday(), bill.getEndday(), bill.getTotal());
            session.removeAttribute("loginReturn");
            response.sendRedirect("home");
        }else{
            request.getRequestDispatcher("EmptyPage.html").forward(request, response);
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
