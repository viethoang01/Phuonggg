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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.BookingBill;
import model.Car;

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
        String type = request.getParameter("type");
        CarDAO dao = new CarDAO();
        if (type.equals("thuexebill")) {
            String thuexeid = request.getParameter("thuexeid");
            Bill billedit = null;
            ArrayList<Bill> listthuexe = dao.getAllThuexeBill();
            if (listthuexe != null) {
                for (int i = 0; i < listthuexe.size(); i++) {
                    if (listthuexe.get(i).getId().equals(thuexeid)) {
                        billedit = listthuexe.get(i);

                        break;
                    }

                }
            }
//        id,accId,carId,carname,thoiluong,donvi,nameCustomer,CMND,email,phone,code_inv,daybill,startday,endday,price,total

            request.setAttribute("thuexeid", billedit.getId());
            request.setAttribute("carid", billedit.getCarId());
            request.setAttribute("carname", billedit.getCarname());
            request.setAttribute("thoiluong", billedit.getThoiluong());
            request.setAttribute("donvi", billedit.getDonvi());
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
            request.setAttribute("accid", billedit.getAccId());

            request.getRequestDispatcher("editthuexe.jsp").forward(request, response);
        }
        if (type.equals("dichvubill")) {
            String dichvuid = request.getParameter("dichvuid");
            BookingBill bookingbill = null;
            ArrayList<BookingBill> listbill = dao.getAllBookingBill();
            for (BookingBill bookingBill : listbill) {
                if (bookingBill.getId().equals(dichvuid)) {
                    bookingbill = bookingBill;
                    break;
                }
            }
            if (bookingbill == null) {
                request.getRequestDispatcher("EmptyPage.html").forward(request, response);
            }
            request.setAttribute("dichvuid", bookingbill.getId());
            request.setAttribute("namecustomer", bookingbill.getNameCustomer());
            request.setAttribute("phone", bookingbill.getPhone());
            request.setAttribute("email", bookingbill.getEmail());
            request.setAttribute("mauxe", bookingbill.getCarName());
            request.setAttribute("km", bookingbill.getKm());
            request.setAttribute("bienso", bookingbill.getBienso());
            request.setAttribute("ngay", bookingbill.getNgay());
            request.setAttribute("gio", bookingbill.getGio());
            request.setAttribute("daybill", bookingbill.getNgaybooking());
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
            request.getRequestDispatcher("editdichvu.jsp").forward(request, response);
        }
        if (type.equals("tainguyen")) {
            String tainguyenid = request.getParameter("tainguyenid");
            Car car = dao.getCar(tainguyenid);
            request.setAttribute("id", car.getId());
            request.setAttribute("img", car.getImg());
            request.setAttribute("name", car.getName());
            request.setAttribute("info", car.getInfo());
            request.setAttribute("price", car.getPrice());
            request.setAttribute("current", car.getCurrent());
            request.setAttribute("color", car.getColor());
            request.setAttribute("type", type);
            request.getRequestDispatcher("edittainguyen.jsp").forward(request, response);
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
        CarDAO dao = new CarDAO();
        String type = request.getParameter("type");
        if (type.equals("thuexe")) {
            String carid = (String) request.getParameter("carid");
            String accid = (String) request.getParameter("accid");
            String carname = (String) request.getParameter("carname");
            String thoiluong = (String) request.getParameter("thoiluong");
            String donvi = (String) request.getParameter("donvi");
            String nameCustomer = (String) request.getParameter("nameCustomer");
            String CMND = (String) request.getParameter("CMND");
            String email = (String) request.getParameter("email");
            String phone = (String) request.getParameter("phone");
            String code_inv = (String) request.getParameter("code_inv");
            String daybill = (String) request.getParameter("daybill");
            String startday = (String) request.getParameter("startday");
            String endday = (String) request.getParameter("endday");
            String total = (String) request.getParameter("total");
            String id = (String) request.getParameter("thuexeid");

            
            dao.editThuexe(id, accid, carid, carname, thoiluong, donvi, nameCustomer, CMND, email, phone, code_inv, daybill, startday, endday, total);
            response.sendRedirect("manage");
        }
        if(type.equals("tainguyen")){
            String id = request.getParameter("id");
            String img =request.getParameter("img");
            String name =request.getParameter("name");
            String info =request.getParameter("info");
            String price =request.getParameter("price");
            String current =request.getParameter("current")!= null ? "1":"0";
            String color =request.getParameter("color");
            
            dao.UpdateCar(id, name, info, img, price, current, color);
            response.sendRedirect("manage?type=tainguyen");
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
