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
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        
        char arr[] = email.toCharArray();
        boolean check = false,check2 = false,check3 = false;
        
        for (int i = 0; i < arr.length; i++) {
            if(Character.toUpperCase(arr[i]) == arr[i]){
                check = true;
            }if(Character.toLowerCase(arr[i]) == arr[i]){
                check2 = true;
            }
            
            if(Character.isDigit(arr[i])){
                check3= true;
            }
             
        }
        if(arr.length < 8 || !check ||!check2 ||!check3){
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        if(!repass.equals(pass)){
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
        dao.SignupAcc(email, pass);
        char HeaderOfEmail = 0;
        for (int i = 0; i < email.toCharArray().length; i++) {
            if(Character.isLetter(email.toCharArray()[i])){
                HeaderOfEmail = email.toCharArray()[i];
                break;
            }
            
        }
        request.setAttribute("style_circle", "display: block");        
        request.setAttribute("HeaderOfEmail", HeaderOfEmail);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
