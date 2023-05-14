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
import model.Car;
import model.Message;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "MessageServlet", urlPatterns = {"/message"})
public class MessageServlet extends HttpServlet {

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
            out.println("<title>Servlet MessageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MessageServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");

        CarDAO dao = new CarDAO();
        HttpSession session = request.getSession();
        Object objAcc = session.getAttribute("user");
        if (objAcc != null) {
            Account acc = (Account) objAcc;
            if (acc.getName().equals("Admin")) {
                String fromid = request.getParameter("fromid");
                if (!fromid.equals("")) {
                    Account accCustomer = dao.getAcc(fromid);
                    String Customerid = String.valueOf(accCustomer.getId());
                    ArrayList<Car> list = dao.getAll();
                    request.setAttribute("listcar", list); // get list car

                    
                    request.setAttribute("usersend", fromid);
                    request.setAttribute("to", Customerid);
//                    response.getWriter().print(Customerid);
                    ArrayList<Message> MessageYouSend = dao.getAllMessageofUser(Customerid, "45");     /// list message
                    ArrayList<Message> MessageYouReceive = dao.getAllMessageofUser("45", Customerid);

                    if (!MessageYouReceive.isEmpty() && MessageYouSend.isEmpty()) {
                        request.setAttribute("MYR", MessageYouReceive);
                        request.setAttribute("MYS", null);
                    }
                    if (MessageYouReceive.isEmpty() && !MessageYouSend.isEmpty()) {
                        request.setAttribute("MYR", null);
                        request.setAttribute("MYS", MessageYouSend);
                    }
                    if (!MessageYouReceive.isEmpty() && !MessageYouSend.isEmpty()) {
                        request.setAttribute("MYR", MessageYouReceive);
                        request.setAttribute("MYS", MessageYouSend);
                        request.setAttribute("messageAdmin", "none");
                    }
                    if (MessageYouReceive.isEmpty() && MessageYouSend.isEmpty()) {
                        request.setAttribute("MYR", null);
                        request.setAttribute("MYS", null);
                    }

                    request.setAttribute("manage", "display: block");
                    request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe 

                    request.setAttribute("email_user", "Admin");
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("EmptyPage.html");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("contentsend");
        String to = request.getParameter("to");
        HttpSession session = request.getSession();
        Object objacc = session.getAttribute("user");
//        response.getWriter().print(to);
        if (objacc != null) {
            Account acc = (Account) objacc;
            CarDAO dao = new CarDAO();
            dao.addMessage(String.valueOf(acc.getId()), to, content);
            if(acc.getName().equals("Admin")){
                ArrayList<Account> listacc = dao.ListAcc();
            String emailCus = "";                              // return dung tin khach hang dang tro chuyen
            for (Account account : listacc) {               
                if(account.getId() == Integer.parseInt(to)){
                    emailCus = account.getName();
                }
            }
            response.sendRedirect("message?fromid="+emailCus);
            }else{
                response.sendRedirect("home");
            }
        } else {
            response.sendRedirect("login.jsp");
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
