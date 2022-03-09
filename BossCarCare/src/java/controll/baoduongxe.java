/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
import model.BookingBill;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "baoduongxe", urlPatterns = {"/baoduong"})
public class baoduongxe extends HttpServlet {

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
            out.println("<title>Servlet baoduongxe</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet baoduongxe at " + request.getContextPath() + "</h1>");
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
        Object obj = request.getParameter("xacnhan");
        if (obj != null) {
            HttpSession session = request.getSession();
            Object bookingbillobj = session.getAttribute("bookingbill");
            if (bookingbillobj != null) {
                BookingBill bookingbill = (BookingBill) bookingbillobj;
                request.setAttribute("namecustomer", bookingbill.getNameCustomer());
                request.setAttribute("phone", bookingbill.getPhone());
                request.setAttribute("email", bookingbill.getEmail());
                request.setAttribute("mauxe", bookingbill.getCarName());
                request.setAttribute("km", bookingbill.getKm());
                request.setAttribute("biensoxe", bookingbill.getBienso());
                
                request.setAttribute("gio", bookingbill.getGio());
                Date startdayDate=null;
                try {
                    startdayDate = new SimpleDateFormat("MM/dd/yyyy").parse(bookingbill.getNgay());
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ThuexeServlet.class.getName()).log(Level.SEVERE, null, ex);
                } 
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String startday = formatter.format(startdayDate);
                request.setAttribute("ngay", startday);
                if (bookingbill.getDichvu().contains("baoduong")) {
                    request.setAttribute("baoduong", "checked");
                }
                if (bookingbill.getDichvu().contains("suachuachung")) {
                    request.setAttribute("suachuachung", "checked");
                }
                if (bookingbill.getDichvu().contains("dongson")) {
                    request.setAttribute("dongson", "checked");
                }
                if (bookingbill.getDichvu().contains("suachuakhac")) {
                    request.setAttribute("suachuakhac", "checked");
                }

            } else {
                request.getRequestDispatcher("EmptyPage.html").forward(request, response);
            }
        }
        request.getRequestDispatcher("baoduongxe.jsp").forward(request, response);
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
        String namecustomer = request.getParameter("namecustomer");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String mauxe = request.getParameter("mauxe");
        String km = request.getParameter("km");
        String biensoxe = request.getParameter("biensoxe");
        String baoduong = request.getParameter("baoduong");
        String suachuachung = request.getParameter("suachuachung");
        String dongson = request.getParameter("dongson");
        String suachuakhac = request.getParameter("suachuakhac");
        String dichvu = "";
        if (baoduong != null) {
            dichvu = baoduong;
            request.setAttribute("baoduong", "checked");
        }
        if (suachuachung != null) {
            request.setAttribute("suachuachung", "checked");
            dichvu = dichvu + "," + suachuachung;
        }
        if (dongson != null) {
            request.setAttribute("dongson", "checked");
            dichvu = dichvu + "," + dongson;
        }
        if (suachuakhac != null) {
            request.setAttribute("suachuakhac", "checked");
            dichvu = dichvu + "," + suachuakhac;
        }
        String ngay = request.getParameter("ngay");
        String gio = request.getParameter("gio");

        request.setAttribute("namecustomer", namecustomer);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("mauxe", mauxe);
        request.setAttribute("km", km);
        request.setAttribute("biensoxe", biensoxe);
        request.setAttribute("ngay", ngay);
        request.setAttribute("gio", gio);

        if (namecustomer.equals("") || phone.equals("") || email.equals("") || mauxe.equals("") || km.equals("") || biensoxe.equals("") || ngay.equals("") || gio.equals("")) {
            if (dichvu == null) {
                request.setAttribute("dichvu_err", "block");
            }

            request.setAttribute("datdichvu_err", "block");
            request.getRequestDispatcher("baoduongxe.jsp").forward(request, response);
        } else {
            boolean checkName = false, checkB = false, checkC = false, checkD = false, checkE = false, checkF = false, checkG = false, checkH = false, checkI = false;
            char[] namechar = namecustomer.toCharArray();
            for (int i = 0; i < namechar.length - 1; i++) {       // check name
                if (Character.isDigit(namechar[i])) {
                    checkB = true;
                    request.setAttribute("namecustomer_err", "red");
                    break;
                }
                if (Character.isLetter(namechar[i]) && namechar[i + 1] == ' ') {
                    checkName = true;

                }
            }

            if (!checkName) {
                request.setAttribute("namecustomer_err", "red");
                checkB = true;
            }
            if (Character.isDigit(namecustomer.toCharArray()[namecustomer.toCharArray().length - 1])) { // check ký tự cuối cùng của string name vì (*) đã không xét ký tự cuối cùng
                request.setAttribute("namecustomer_err", "red");
                checkB = true;
            }
            char[] phonchar = phone.toCharArray();
            if (phonchar.length != 10) {    // check phone
                if (phonchar.length != 11) {
                    checkC = true;
                    request.setAttribute("phone_err", "red");
                }
            } else {
                for (int i = 0; i < phonchar.length; i++) {
                    if (Character.isLetter(phonchar[i])) {
                        request.setAttribute("phone_err", "red");
                        checkC = true;
                        break;
                    }
                }
            }

            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {   // check mail
                request.setAttribute("email_err", "red");
                checkD = true;
            }
            char[] kmchar = km.toCharArray();
            
                for (int i = 0; i < kmchar.length; i++) {
                    if (Character.isLetter(kmchar[i])) {
                        request.setAttribute("km_err", "red");
                        checkE = true;
                        break;
                    }
                }
            
            if(!biensoxe.trim().matches("[a-zA-Z | 0-9]{1,9}")){
                request.setAttribute("enterBiensoxe_err", "red");
                checkF = true;
            }
            

            if (checkB || checkC || checkD || checkE || checkF) {
//                response.getWriter().print(checkB+""+checkC+""+checkD+""+checkE+""+checkF);
            request.getRequestDispatcher("baoduongxe.jsp").forward(request, response);
            } else {
                ngay = java.time.LocalDate.parse(ngay).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                BookingBill bookingbill = new BookingBill("","", namecustomer,email,phone, mauxe, km, biensoxe, dichvu,"", ngay, gio);

                int Accid = 0;
                Account acc = null;
                 CarDAO dao = new CarDAO();
                HttpSession session = request.getSession();
                Object objacc = session.getAttribute("user");
                if(objacc != null){
                    acc = (Account) objacc;   // get account từ session
                    bookingbill.setAccId(String.valueOf(acc.getId()));
                }
               
                if (acc == null) {
                    Cookie[] cookie = request.getCookies();
                    if (cookie != null) {
                        for (Cookie cookie1 : cookie) {
                            if (cookie1.getName().equals("email")) {
                                acc = dao.getAcc(cookie1.getValue());    //get account by email
                                request.setAttribute("Accid", acc.getId()); // set id Account 
                                bookingbill.setAccId(String.valueOf(acc.getId()));  // set id account into phiếu thuê xe
//                                session.setAttribute("bookingbill", bookingbill);
                            }

                        }

                    }
                }
//                Object bookingbillobj = session.getAttribute("bookingbill");
                session.setAttribute("bookingbill", bookingbill);              //set CRI into session để đẩy vào xác nhận
                if (acc == null) {
                    session.setAttribute("loginandbb", "access");
                    response.sendRedirect("login.jsp");
                }else{
                    response.sendRedirect("xacnhanBookingBill");
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
