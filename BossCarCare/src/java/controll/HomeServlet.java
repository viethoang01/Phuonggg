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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Car;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
        CarDAO cd = new CarDAO();
        ArrayList<Car> list = cd.getAll();
        request.setAttribute("listcar", list); // get list car
        String email = "";
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("user");
        Cookie[] cookie = request.getCookies();
        if (cookie != null
                ) {
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("email")) {
                    
                        email = cookie1.getValue();
                    
                }

            }
            
        }
       if(acc == null){
           request.getRequestDispatcher("home.jsp").forward(request, response);
       }
        if(email.equals("") && acc.getName() != null){
            email = acc.getName();
            request.setAttribute("style_circle", "display: block");  // hiển thị circle 
                char HeaderOfEmail = 0;                                 //  lấy ký tự là chữ đầu tiên cho vào circle
                for (int i = 0; i < email.toCharArray().length; i++) {
                    if (Character.isLetter(email.toCharArray()[i])) {
                        HeaderOfEmail = email.toCharArray()[i];
                        break;
                    }

                }
            
            request.setAttribute("HeaderOfEmail", HeaderOfEmail);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
