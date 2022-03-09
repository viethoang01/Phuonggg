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
import model.Bill;
import model.BookingBill;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {

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
        String thuexeid = request.getParameter("thuexeid");
        Bill billedit = new Bill();
        CarDAO dao = new CarDAO();
        ArrayList<Bill> listthuexe = dao.getAllThuexeBill();
        if(listthuexe != null){
            for (int i = 0; i < listthuexe.size(); i++) {
                if(listthuexe.get(i).getId().equals(thuexeid)){
                    billedit = listthuexe.get(i);
                    break;
                }
                
            }
        }
//        id,accId,carId,carname,thoiluong,donvi,nameCustomer,CMND,email,phone,code_inv,daybill,startday,endday,price,total
        request.setAttribute("accid", billedit.getCarId());
        request.setAttribute("carname", billedit.getCarname());
        request.setAttribute("thoiluong", billedit.getThoiluong());
        request.setAttribute("nameCustomer", billedit.getNameCustomer());
        request.setAttribute("CMND", billedit.getCMND());
        request.setAttribute("email", billedit.getEmail());
        request.setAttribute("phone", billedit.getPhone());
        request.setAttribute("code_inv", billedit.getCode_inv());
        request.setAttribute("daybill", billedit.getDaybill());
        request.setAttribute("startday", billedit.getStartday());
        request.setAttribute("endday", billedit.getEndday());
        request.setAttribute("price", billedit.getPrice());
        request.setAttribute("total", billedit.getTotal());
        
        request.getRequestDispatcher("editthuexe.jsp").forward(request, response);
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
