/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import model.Bill;
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
        response.setContentType("text/html;charset=UTF-8");
        String id = (request.getParameter("getcar_id"));    // get Car id
        CarDAO dao = new CarDAO();
        Car car = dao.getCar(id);
        
        HttpSession session = request.getSession();
        Object objUser = session.getAttribute("user");
        if(objUser !=null){
            Account acc = (Account) objUser;
            request.setAttribute("nav_user", "display: block");  // hiển thị nav user
            request.setAttribute("nav_btn_taikhoan", "display: none");  // ẩn btn thue xe   
            request.setAttribute("email_user", acc.getName());
        }
        Object obj1 = session.getAttribute("billid");
        if(obj1 != null){                           // xac nhan lại- thue xe
            Object obj2 = session.getAttribute("bill");
            if(obj2 != null){
                Bill bill = (Bill) obj2;
                request.setAttribute("customer_type", bill.getDonvi());
                request.setAttribute("name_customer", bill.getNameCustomer());
                request.setAttribute("CMND_customer", bill.getCMND());
                request.setAttribute("phone_customer", bill.getPhone());
                request.setAttribute("email_customer", bill.getEmail());
                request.setAttribute("gioithieu_code_customer", bill.getCode_inv());
                if (bill.getDonvi().equals("canhan")) {
                    request.setAttribute("checkcanhan", "selected");
                } else {
                    request.setAttribute("checkdoanhnghiep", "selected");
                }
                
                request.setAttribute("check1", "checked");
                request.setAttribute("Carid", bill.getCarId());                // get thông tin khách hàng nhập trước đó
                
                Date startdayDate=null,enddayDate=null;
                try {
                    startdayDate = new SimpleDateFormat("MM/dd/yyyy").parse(bill.getStartday());
                    enddayDate = new SimpleDateFormat("MM/dd/yyyy").parse(bill.getEndday());
                } catch (ParseException ex) {
                    Logger.getLogger(ThuexeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String startday = formatter.format(startdayDate);
                String endday = formatter.format(enddayDate);
                
                request.setAttribute("startday", startday);
                LocalDate sd = java.time.LocalDate.parse(startday);
                LocalDate ed = java.time.LocalDate.parse(endday);
                request.setAttribute("startday", sd);
                String thoiluongthue = String.valueOf(ed.getDayOfMonth()-sd.getDayOfMonth());
                request.setAttribute("thoiluongthue", thoiluongthue);
                session.removeAttribute("billid");
            }
            
        } else{
            response.getWriter().print("bill null thuexe");
        }
            
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
        if (startday != null) {
            
            request.setAttribute("startday", startday);
//            response.getWriter().print("<p></p>");
        }

        
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
        String songaythue = "";
        switch (donvithue) {
            case "ngay":
                request.setAttribute("checkngay", "selected");
                songaythue =(thoiluongthue);
                break;
            case "thang":
                
                request.setAttribute("checkthang", "selected");
                songaythue = String.valueOf(Integer.parseInt(thoiluongthue)*30);
                break;
            case "nam":
                request.setAttribute("checknam", "selected");
                songaythue = String.valueOf(Integer.parseInt(thoiluongthue)*30*12);
                break;

        }
        String endday = "";
        if(!songaythue.equals("")){
            endday = java.time.LocalDate.parse(startday).plusDays(Integer.parseInt(songaythue)).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            request.setAttribute("endday", endday);
        }
        CarDAO dao = new CarDAO();
        Car car = dao.getCar((Carid));
        
        request.setAttribute("choosed_car_info", car);  // get car được chọn trước đó
        request.setAttribute("listcar", dao.getAll()); // get all car
        
        if (name_customer.equals("") || CMND_customer.equals("") || phone_customer.equals("") // all must not null (something can not)
                || email_customer.equals("") || check1 == null) {
            request.setAttribute("msg", "block");
            request.getRequestDispatcher("thuexe.jsp").forward(request, response);
        } else {

            boolean checkName = false, checkB = false, checkC = false, checkD = false, checkE = false, checkF = false, checkG = false, checkH = false, checkI = false;
            char[] namechar = name_customer.toCharArray();
            for (int i = 0; i < namechar.length - 1; i++) {       // check name
                if (Character.isDigit(namechar[i])) {
                    checkB = true;
                    request.setAttribute("nameblock", "block");
                    break;
                }
                if (Character.isLetter(namechar[i]) && namechar[i + 1] == ' ') {
                    checkName = true;

                }
            }

            if (!checkName) {
                request.setAttribute("nameblock", "block");
                checkB = true;
            }
            if (Character.isDigit(namechar[namechar.length - 1])) { // check ký tự cuối cùng của string name vì (*) đã không xét ký tự cuối cùng
                request.setAttribute("nameblock", "block");
                checkB = true;
            }

            char[] CMNDchar = CMND_customer.toCharArray();
            if (CMNDchar.length != 9) {    // check CMND
                if (CMNDchar.length != 12) {
                    checkC = true;
                    request.setAttribute("CMNDblock", "block");
                }
            }
            for (int i = 0; i < CMNDchar.length; i++) {
                if (Character.isLetter(CMNDchar[i])) {
                    checkD = true;
                    request.setAttribute("CMNDblock", "block");
                    break;
                }
            }

            char[] phonechar = phone_customer.toCharArray();
            if (phonechar.length != 10) {    // check phone
                if (phonechar.length != 11) {
                    checkE = true;
                    request.setAttribute("phoneblock", "block");
                }
            }
            for (int i = 0; i < phonechar.length; i++) {
                if (Character.isLetter(phonechar[i])) {
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
                String totalmoney =String.valueOf((int)car.getPrice()*Integer.parseInt(songaythue));  
                startday = java.time.LocalDate.parse(startday).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                String carPriceString = String.valueOf(car.getPrice());
                
                Bill bill = new Bill("", Carid, thoiluongthue, customer_type, name_customer, CMND_customer, email_customer, phone_customer, gioithieu_code_customer, startday, endday, carPriceString, totalmoney);
                int Accid = 0;
                Account acc = null;
                HttpSession session = request.getSession();
                Object objacc = session.getAttribute("user");   // get account từ session
                if(objacc != null){
                    acc =(Account) objacc;
                    bill.setAccId(String.valueOf(acc.getId())); 
                }
                if(acc == null){
                    Cookie[] cookie = request.getCookies();
                    if (cookie != null) {
                        for (Cookie cookie1 : cookie) {
                            if (cookie1.getName().equals("email")) {
                                acc = dao.getAcc(cookie1.getValue());    //get account by email
                                request.setAttribute("Accid", acc.getId()); // set id Account 
                                bill.setAccId(String.valueOf(acc.getId()));  // set id account into phiếu thuê xe
//                                session.setAttribute("bill", bill);              //set CRI into session để đẩy vào xác nhận
                            }

                        }

                    }
                }
                 session.setAttribute("bill", bill);              //set CRI into session để đẩy vào xacnhan xử lý (set trong trường hợp acc vẫn chưa tồn tại)
                if(acc == null){
                   
                    session.setAttribute("loginReturn", "1");
                    response.sendRedirect("login.jsp");
                }else{
                    response.sendRedirect("xacnhan");
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
