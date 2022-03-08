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
import model.BookingBill;
import model.BookingInvoice;
import model.CarRentalInvoice;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "XacnhanBookingBill", urlPatterns = {"/xacnhanBookingBill"})
public class XacnhanBookingBill extends HttpServlet {

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
            out.println("<title>Servlet XacnhanBookingBill</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XacnhanBookingBill at " + request.getContextPath() + "</h1>");
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
        
        Object obj = session.getAttribute("bookingbill");
        
        if(obj != null){
            BookingBill bill = (BookingBill) obj;
            

   
            request.setAttribute("Accid", bill.getAccId());
            request.setAttribute("name_customer", bill.getNameCustomer());
            request.setAttribute("phone_customer", bill.getPhone());
            request.setAttribute("email_customer", bill.getEmail());
            request.setAttribute("mauxe", bill.getCarName());
            request.setAttribute("km", bill.getKm());
            request.setAttribute("bienso", bill.getBienso());
            request.setAttribute("ngay", bill.getNgay());
            request.setAttribute("dichvu", bill.getDichvu());
            request.setAttribute("gio", bill.getGio());
           
            
            request.getRequestDispatcher("xacnhanBookingBill.jsp").forward(request, response);
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
        Object obj = session.getAttribute("bookingbill");
        if(obj != null){
            BookingBill bill = (BookingBill) obj;
            BookingInvoice BB = new BookingInvoice();
            BB.addBill(bill.getAccId(), bill);     // 1 acc có thể có nhiều bill
//            response.getWriter().print(bill.getAccId());
            CarDAO dao = new CarDAO();
            dao.InsertBooking
            (bill.getAccId(), bill.getNameCustomer(), bill.getPhone(), bill.getEmail(), bill.getCarName(), bill.getKm(), bill.getBienso(), bill.getDichvu(), bill.getNgay(), bill.getGio());
            session.removeAttribute("loginandbb"); // không cần lưu kết nối từ baoduongxe.java sang xacnhanbooking.java
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
