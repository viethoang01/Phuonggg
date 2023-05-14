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
import model.Account;
/*import org.apache.catalina.User

/**
 *
 * @author Administrator
 */
@WebServlet(name="SignupServlet", urlPatterns={"/signup"})
public class SignupServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet SignupServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CarDAO dao = new CarDAO();
        String email = request.getParameter("email").trim();
        String pass = request.getParameter("password").trim();
        String repass = request.getParameter("repassword").trim();
        request.setAttribute("email_value", email);
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            request.setAttribute("email_err", "block");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        ArrayList<Account> list = dao.ListAcc();
        
        if(pass.length() < 8){
            request.setAttribute("pass_err", "block");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        
        char arr[] = pass.toCharArray();
        boolean check = false,check2 = false,check3 = false,check4 = false;
        
        for (int i = 0; i < arr.length; i++) {
            if(Character.isUpperCase(arr[i])){
                check = true;
            }if(Character.isLowerCase(arr[i])){
                check2 = true;
            }
            
            if(Character.isDigit(arr[i])){
                check3= true;
            }
            if(Character.isLetter(arr[i])){
                check4= true;
            }
             
        }
        if(!check ||!check2 ||!check3 || !check4){
            request.setAttribute("pass_err", "block");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        if(!repass.equals(pass)){
            request.setAttribute("repass_err", "block");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        boolean valiableEmail = false;
        for (Account account : list) {
            if(account.getName().equals(email)){
                valiableEmail = true;
            }
        }
        if(valiableEmail){
            request.setAttribute("email_err_block", "block");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        dao.SignupAcc(email, pass);
        
        
        response.sendRedirect("login.jsp");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
