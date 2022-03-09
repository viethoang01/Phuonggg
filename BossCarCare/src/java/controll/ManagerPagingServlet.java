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
@WebServlet(name = "ManagerPagingServlet", urlPatterns = {"/manage"})
public class ManagerPagingServlet extends HttpServlet {

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
        CarDAO dao = new CarDAO();
        
        String typepage =request.getParameter("typepage");
        if(typepage == null) typepage = "0";
        if(typepage == null||typepage.equals("0")){         // hóa đơn thuê xe
            
            String page = request.getParameter("page");
            if(page == null || page.equals("")) page = "1";
            int pageindex = Integer.parseInt(page);
            int pagesize = 5;
            int totalNumberRow = dao.getTotalNumberRow();
            int totalNumberPage = totalNumberRow%pagesize == 0 ? totalNumberRow/pagesize : totalNumberRow/pagesize+1;
            ArrayList<Bill> listbill = dao.getPage(page, "5");
            request.setAttribute("listthuexe", listbill);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("typepage_thuexe_Selected", "selected");
            request.setAttribute("totalNumberPage", totalNumberPage);
            request.setAttribute("typepage", typepage);
            request.getRequestDispatcher("manager.jsp").forward(request, response);
//response.getWriter().print(listbill.get(0).getCarname());
            if(listbill == null){
                response.getWriter().print("null");
            }
        }
        else if(typepage.equals("1")){
            String page = request.getParameter("page");
            if(page == null || page.equals("")) page = "1";
            int pageindex = Integer.parseInt(page);
            int pagesize = 5;
            int totalNumberRow = dao.getTotalNumberRow();
            int totalNumberPage = totalNumberRow%pagesize == 0 ? totalNumberRow/pagesize : totalNumberRow/pagesize+1;
            ArrayList<BookingBill> listdichvu = dao.getBookingPage( pageindex,pagesize);
            request.setAttribute("listdichvu", listdichvu);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("typepage_dichvu_Selected", "selected");
            request.setAttribute("totalNumberPage", totalNumberPage);
            request.setAttribute("typepage", typepage);
//            response.getWriter().print(listdichvu.get(0).getNameCustomer());
            request.getRequestDispatcher("manager.jsp").forward(request, response);
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
