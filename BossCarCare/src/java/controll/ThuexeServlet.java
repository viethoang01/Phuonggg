/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ThuexeServlet", urlPatterns = {"/thuexe"})
public class ThuexeServlet extends HttpServlet {

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

        String id = (request.getParameter("getcar_id"));    // get Car id
        CarDAO dao = new CarDAO();
        Car car = dao.getCar(id);

        ArrayList<Car> list = dao.getAll();
        if (car == null) {
            request.getRequestDispatcher("home").forward(request, response);

        } else {

            request.setAttribute("choosed_car_info", car);
            request.setAttribute("listcar", list);
            request.getRequestDispatcher("thuexe.jsp").forward(request, response);
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
        String Carid = request.getParameter("car_id_choose");
        String startday = request.getParameter("startday");
       
        String donvithue = request.getParameter("donvithue");
        String thoiluongthue = request.getParameter("thoiluongthue");
        String customer_type = request.getParameter("customer_type");
        String name_customer = request.getParameter("name_customer");
        String CMND_customer = request.getParameter("CMND_customer");
        String phone_customer = request.getParameter("phone_customer");
        String email_customer = request.getParameter("email_customer");
        String gioithieu_code_customer = request.getParameter("gioithieu_code_customer");
        String check1 = request.getParameter("check1");
        request.setAttribute("Carid", Carid);                // get thông tin khách hàng nhập trước đó

        request.setAttribute("thoiluongthue", thoiluongthue);
        if (!startday.equals("")) {
            request.setAttribute("startday", java.time.LocalDate.parse(startday));
            request.setAttribute("startdayString", startday);
        }
        String endday = java.time.LocalDate.parse(startday).plusDays(Integer.parseInt(thoiluongthue)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        request.setAttribute("endday", endday);
        request.setAttribute("customer_type", customer_type);
        request.setAttribute("name_customer", name_customer);
        request.setAttribute("CMND_customer", CMND_customer);
        request.setAttribute("phone_customer", phone_customer);
        request.setAttribute("email_customer", email_customer);
        request.setAttribute("gioithieu_code_customer", gioithieu_code_customer);
        if (customer_type.equals("canhan")) {
            request.setAttribute("checkcanhan", "selected");
        } else {
            request.setAttribute("checkdoanhnghiep", "selected");
        }
        if (check1 != null) {
            request.setAttribute("check1", "checked");
        }
        switch (donvithue) {
            case "ngay":
                request.setAttribute("checkngay", "selected");
                break;
            case "thang":
                request.setAttribute("checkthang", "selected");
                break;
            case "nam":
                request.setAttribute("checknam", "selected");
                break;

        }

        CarDAO dao = new CarDAO();
        Car car = dao.getCar((Carid));
        
        request.setAttribute("choosed_car_info", car);  // get car được chọn trước đó
        request.setAttribute("listcar", dao.getAll()); // get all car
        double  totalmoney =  car.getPrice();
        request.setAttribute("totalmoney", totalmoney);
        if (name_customer.equals("") || CMND_customer.equals("") || phone_customer.equals("") // all must not null (something can not)
                || email_customer.equals("") || check1 == null) {
            request.setAttribute("msg", "block");
            request.getRequestDispatcher("thuexe.jsp").forward(request, response);
        } else {

            boolean checkName = false, checkB = false, checkC = false, checkD = false, checkE = false, checkF = false, checkG = false, checkH = false, checkI = false;
            for (int i = 0; i < name_customer.toCharArray().length - 1; i++) {       // check name
                if (Character.isDigit(name_customer.toCharArray()[i])) {
                    checkB = true;
                    request.setAttribute("nameblock", "block");
                    break;
                }
                if (Character.isLetter(name_customer.toCharArray()[i]) && name_customer.toCharArray()[i + 1] == ' ') {
                    checkName = true;

                }
            }

            if (!checkName) {
                request.setAttribute("nameblock", "block");
                checkB = true;
            }
            if (Character.isDigit(name_customer.toCharArray()[name_customer.toCharArray().length - 1])) { // check ký tự cuối cùng của string name vì (*) đã không xét ký tự cuối cùng
                request.setAttribute("nameblock", "block");
                checkB = true;
            }

            if (CMND_customer.toCharArray().length != 9) {    // check CMND
                if (CMND_customer.toCharArray().length != 12) {
                    checkC = true;
                    request.setAttribute("CMNDblock", "block");
                }
            }
            for (int i = 0; i < CMND_customer.toCharArray().length; i++) {
                if (Character.isLetter(CMND_customer.toCharArray()[i])) {
                    checkD = true;
                    request.setAttribute("CMNDblock", "block");
                    break;
                }
            }

            if (phone_customer.toCharArray().length != 10) {    // check phone
                if (phone_customer.toCharArray().length != 11) {
                    checkE = true;
                    request.setAttribute("phoneblock", "block");
                }
            }
            for (int i = 0; i < phone_customer.toCharArray().length; i++) {
                if (Character.isLetter(phone_customer.toCharArray()[i])) {
                    request.setAttribute("phoneblock", "block");
                    checkF = true;
                    break;
                }
            }

            if (!email_customer.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {   // check mail
                request.setAttribute("emailblock", "block");
                checkG = true;
            }

            if (thoiluongthue.equals("")) {
                checkH = true;
                request.setAttribute("thoiluongthuexeblock", "block");
            }
            if (startday.equals("")) {
                checkI = true;
                request.setAttribute("startdayblock", "block");
            }

            if (checkB || checkC || checkD || checkE || checkF || checkG || checkH || checkI) {
                request.getRequestDispatcher("thuexe.jsp").forward(request, response);
            } else {
                int Accid = 0;
                Account acc = null;
                HttpSession session = request.getSession();
                acc =(Account) session.getAttribute("user");
                if(acc == null){
                    Cookie[] cookie = request.getCookies();
                    if (cookie != null) {
                        for (Cookie cookie1 : cookie) {
                            if (cookie1.getName().equals("email")) {
                                acc = dao.getAcc(cookie1.getValue());
                                request.setAttribute("Accid", acc.getId());
                            }

                        }

                    }
                }
                if(acc == null){
                    session.setAttribute("loginReturn", "1");
                    response.sendRedirect("login.jsp");
                }else{
                    response.sendRedirect("xacnhan.html");
                }
                
            }

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
