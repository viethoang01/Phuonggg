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

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ManageServlet", urlPatterns = {"/managepage"})
public class ManageServlet extends HttpServlet {

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
            
            int totalNumberRow = dao.getTotalNumberRow();
            int totalNumberPage = totalNumberRow%pageindex == 0 ? totalNumberRow/pageindex : totalNumberRow/pageindex+1;
            ArrayList<Bill> listbill = dao.getPage(page, "10");
            request.setAttribute("listthuexe", listbill);
            request.setAttribute("pageindex", pageindex);
            request.setAttribute("typepagevaSelected", "selected");
            request.setAttribute("totalNumberPage", totalNumberPage);
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
