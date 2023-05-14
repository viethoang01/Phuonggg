/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Bill;
import model.BookingBill;
import model.Car;
import model.CategoryCar;
import model.Message;

/**
 *
 * @author Administrator
 */
public class CarDAO extends BaseDAO<Car> {

    public void addMessage(String fromid, String toid, String content) {
        try {
            String sql = "insert into [Messages] (fromid,toid,content) values\n"
                    + "(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fromid);
            statement.setString(2, toid);
            statement.setString(3, content);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Message> getAllMessageofUser1M() {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select AllMessUser.id, AllMessUser.content,AllMessUser.usersend,AllMessUser.[time],AllMessUser.toid,AllMessUser.isread  from\n"
                    + "(select m.fromid, max([time]) as maxTime  from [Messages] m inner join Account acc on acc.id = m.fromid where toid = 45 group by m.fromid) as MessLastOfUser\n"
                    + "INNER JOIN\n"
                    + "(select m.id,acc.name as usersend,toid,[time],content,isread from [Messages] m inner join Account acc on acc.id = m.fromid where toid = 45) as AllMessUser \n"
                    + "on AllMessUser.[time] = MessLastOfUser.maxTime where usersend != 'Admin'";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("id"));
                s.setFrom(rs.getString("usersend"));
                s.setTo(rs.getString("toid"));
                s.setContent(rs.getString("content"));
                s.setTime(rs.getString("time"));
                s.setIsread(rs.getString("isread"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Message> getAllMessageofUser(String toid, String fromid) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select m.id,acc.name as usersend,toid,[time],content,isread from [Messages] m inner join Account acc on acc.id = m.fromid where toid = ? and fromid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, toid);
            statement.setString(2, fromid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("id"));
                s.setFrom(rs.getString("usersend"));
                s.setTo(rs.getString("toid"));
                s.setContent(rs.getString("content"));
                s.setTime(rs.getString("time"));
                s.setIsread(rs.getString("isread"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<Car> getAll() {
        ArrayList<Car> list = new ArrayList<>();
        try {
            String sql = "select c.id, c.name,info,img,price,[current],color,cc.name as[cateName]\n"
                    + "from Cars c left join Categories cc \n"
                    + "on categoryid = cc.id ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Car s = new Car();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setInfo(rs.getString("info"));
                s.setImg(rs.getString("img"));
                s.setPrice(rs.getDouble("price"));
                s.setCurrent(!rs.getString("current").equals('0'));// chưa thuê 0 = false
                s.setColor(rs.getString("color"));
                s.setNameCat(rs.getString("cateName"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<CategoryCar> getAllCat() {
        ArrayList<CategoryCar> list = new ArrayList<>();
        try {
            String sql = "select * from Categories";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CategoryCar s = new CategoryCar();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Car getCar(String id) {
        try {
            String sql = "select c.id,c.name,info,img,price,[current],color,cc.name as[cateName]\n"
                    + "from Cars c left join Categories cc \n"
                    + "on categoryid = cc.id  where c.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Car s = new Car();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setInfo(rs.getString("info"));
                s.setImg(rs.getString("img"));
                s.setPrice(rs.getDouble("price"));
                s.setCurrent(!rs.getString("current").equals('0'));// chưa thuê 0 = false
                s.setColor(rs.getString("color"));
                s.setNameCat(rs.getString("cateName"));
                return s;
            }

        } catch (SQLException ex) {

        }
        return null;
    }

    public void SignupAcc(String name, String password) {
        try {
            String sql = "insert into Account values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Account> ListAcc() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            String sql = "select * from Account";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                list.add(account);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public Account getAcc(String name) {
        try {
            String sql = "select * from Account where name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            ResultSet rs = statement.executeQuery();
            Account account = new Account();
            while (rs.next()) {
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                return account;
            }

        } catch (SQLException ex) {

        }
        return null;
    }

    public void InsertRental(String Carid, String Accid, String songaythue, String donvi, String namecustomer, String CMND, String phone, String email, String code_gioithieu, String start_date_of_hire, String end_date_of_hire, String totalmoney) {
        try {
            String sql = "insert into CarRentalInvoice (Carid,Accid,songaythue,donvi, namecustomer, CMND, phone, email, code_gioithieu,start_date_of_hire,end_date_of_hire,totalmoney) values\n"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Carid);
            statement.setString(2, Accid);
            statement.setString(3, songaythue);
            statement.setString(4, donvi);
            statement.setString(5, namecustomer);

            statement.setString(6, CMND);
            statement.setString(7, phone);
            statement.setString(8, email);
            statement.setString(9, code_gioithieu);
            statement.setString(10, start_date_of_hire);
            statement.setString(11, end_date_of_hire);
            statement.setString(12, totalmoney);
            statement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void InsertBooking(String Accid, String namecustomer, String phone, String email, String mauxe, String km, String biensoxe, String dichvu, String ngay, String gio) {
        try {
            String sql = "insert into BookingInvoice (Accid,namecustomer,phone,email,carname,km,bienso,dichvu,date_maintenance,gio) values\n"
                    + "                           (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Accid);
            statement.setString(2, namecustomer);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, mauxe);

            statement.setString(6, km);
            statement.setString(7, biensoxe);
            statement.setString(8, dichvu);
            statement.setString(9, ngay);
            statement.setString(10, gio);

            statement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Bill> getCRI(String accId) {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = "select hoadonid,accid,rs2.carid,cate.name+' '+rs2.carname as carname,donvi,namecustomer,CMND,email,phone,code_gioithieu,date_of_hire,start_date_of_hire,end_date_of_hire,songaythue,price, totalmoney\n"
                    + "from Categories cate inner join \n"
                    + "(select hoadonid,accid,categoryid,rs.carid,car.name as carname,donvi,namecustomer,CMND,email,phone,code_gioithieu,date_of_hire,start_date_of_hire,end_date_of_hire,songaythue,price, CAST( totalmoney AS int)as totalmoney\n"
                    + " from Cars car inner join \n"
                    + " (select acc.id as accid, carid,donvi,namecustomer,CMND,email,phone,code_gioithieu,date_of_hire,start_date_of_hire,end_date_of_hire,songaythue,totalmoney,CRI.id as hoadonid from Account acc inner join CarRentalInvoice CRI on acc.id =  CRI.Accid and acc.id = ?) as rs \n"
                    + "on rs.carid = car.id)as rs2\n"
                    + "on rs2.categoryid = cate.id ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, accId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setAccId(rs.getString("accid"));
                bill.setCarname(rs.getString("carname"));
                bill.setDonvi(rs.getString("donvi"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setCMND(rs.getString("CMND"));
                bill.setEmail(rs.getString("email"));
                bill.setPhone(rs.getString("phone"));
                bill.setCode_inv(rs.getString("code_gioithieu"));
                bill.setDaybill(rs.getString("date_of_hire"));
                bill.setStartday(rs.getString("start_date_of_hire"));
                bill.setEndday(rs.getString("end_date_of_hire"));
                bill.setThoiluong(rs.getString("songaythue"));
                bill.setPrice(rs.getString("price"));
                bill.setTotal(rs.getString("totalmoney"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public ArrayList<BookingBill> getBB(String accId) {
        ArrayList<BookingBill> list = new ArrayList<>();
        try {
            String sql = "select * from BookingInvoice where Accid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, accId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                BookingBill bill = new BookingBill();
                bill.setId(rs.getString("id"));
                bill.setAccId(rs.getString("Accid"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setPhone(rs.getString("phone"));
                bill.setEmail(rs.getString("email"));
                bill.setNgaybooking(rs.getString("date_of_booking"));
                bill.setNgay(rs.getString("date_maintenance"));
                bill.setGio(rs.getString("gio"));
                bill.setBienso(rs.getString("bienso"));
                bill.setCarName(rs.getString("carname"));
                bill.setKm(rs.getString("km"));
                bill.setDichvu(rs.getString("dichvu"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public ArrayList<Bill> getPage(String pageindex, String gap) {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = "select hoadonid,rs1.carname,rs1.price,rs1.carname, rs1.carid,c.Accid,c.donvi,c.namecustomer,c.CMND,c.phone,c.email,c.code_gioithieu,c.date_of_hire,c.start_date_of_hire,c.end_date_of_hire,c.songaythue,c.totalmoney  from CarRentalInvoice c inner join \n"
                    + "(select ROW_NUMBER() over(order by cri.id asc) as rownum,cri.id,cri.carid,c.name as carname , c.price,cri.id as hoadonid from CarRentalInvoice cri inner join Cars c on c.id = cri.carid) as rs1\n"
                    + "on rs1.id = c.id\n" + "WHERE rownum >= ((?-1) * ?) + 1 AND rownum <=  ?* ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(pageindex));
            statement.setInt(2, Integer.parseInt(gap));
            statement.setInt(3, Integer.parseInt(pageindex));
            statement.setInt(4, Integer.parseInt(gap));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Bill bill = new Bill();
                bill.setId(rs.getString("hoadonid"));
                bill.setAccId(rs.getString("Accid"));
                bill.setDonvi(rs.getString("donvi"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setCMND(rs.getString("CMND"));
                bill.setEmail(rs.getString("email"));
                bill.setPhone(rs.getString("phone"));
                bill.setCode_inv(rs.getString("code_gioithieu"));
                bill.setDaybill(rs.getString("date_of_hire"));
                bill.setStartday(rs.getString("start_date_of_hire"));
                bill.setEndday(rs.getString("end_date_of_hire"));
                bill.setThoiluong(rs.getString("songaythue"));
                bill.setTotal(rs.getString("totalmoney"));
                bill.setCarId(rs.getString("carid"));
                bill.setCarname(rs.getString("carname"));
                bill.setPrice(rs.getString("price"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalNumberRow(String table) {
        try {
            String sql = "select COUNT(*)as maxrownum from " + table;
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                return rs.getInt("maxrownum");
            }

        } catch (SQLException ex) {

        }
        return 0;
    }

    public ArrayList<BookingBill> getBookingPage(int pageindex, int gap) {
        ArrayList<BookingBill> list = new ArrayList<>();
        try {
            String sql = "select * from\n"
                    + "(select * from BookingInvoice ) as rs1 inner join\n"
                    + "(select row_number() over(order by id asc) as rownum,id from BookingInvoice\n"
                    + ") as rs2 on rs1.id = rs2.id WHERE rownum >= ((?-1) * ?) + 1 AND rownum <=  ? * ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (pageindex));
            statement.setInt(2, (gap));
            statement.setInt(3, (pageindex));
            statement.setInt(4, (gap));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                BookingBill bill = new BookingBill();
                bill.setId(rs.getString("id"));
                bill.setAccId(rs.getString("Accid"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setPhone(rs.getString("phone"));
                bill.setEmail(rs.getString("email"));
                bill.setNgaybooking(rs.getString("date_of_booking"));
                bill.setNgay(rs.getString("date_maintenance"));
                bill.setGio(rs.getString("gio"));
                bill.setBienso(rs.getString("bienso"));
                bill.setCarName(rs.getString("carname"));
                bill.setKm(rs.getString("km"));
                bill.setDichvu(rs.getString("dichvu"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public ArrayList<Bill> getAllThuexeBill() {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            String sql = "select * from CarRentalInvoice";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Bill bill = new Bill();

                bill.setId(rs.getString("id"));
                bill.setAccId(rs.getString("Accid"));
                bill.setDonvi(rs.getString("donvi"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setCMND(rs.getString("CMND"));
                bill.setEmail(rs.getString("email"));
                bill.setPhone(rs.getString("phone"));
                bill.setCode_inv(rs.getString("code_gioithieu"));
                bill.setDaybill(rs.getString("date_of_hire"));
                bill.setStartday(rs.getString("start_date_of_hire"));
                bill.setEndday(rs.getString("end_date_of_hire"));
                bill.setThoiluong(rs.getString("songaythue"));
                bill.setTotal(rs.getString("totalmoney"));
                bill.setCarId(rs.getString("carid"));

                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<BookingBill> getAllBookingBill() {
        ArrayList<BookingBill> list = new ArrayList<>();
        try {
            String sql = "select * from BookingInvoice";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                BookingBill bill = new BookingBill();
                bill.setId(rs.getString("id"));
                bill.setAccId(rs.getString("Accid"));
                bill.setNameCustomer(rs.getString("namecustomer"));
                bill.setPhone(rs.getString("phone"));
                bill.setEmail(rs.getString("email"));
                bill.setNgaybooking(rs.getString("date_of_booking"));
                bill.setNgay(rs.getString("date_maintenance"));
                bill.setGio(rs.getString("gio"));
                bill.setBienso(rs.getString("bienso"));
                bill.setCarName(rs.getString("carname"));
                bill.setKm(rs.getString("km"));
                bill.setDichvu(rs.getString("dichvu"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

    public void delete(String table, String id) {
        try {
            String sql = "delete from " + table + " where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editThuexe(String id, String accId, String carId, String thoiluong, String donvi, String nameCustomer, String CMND, String email, String phone, String code_inv, String daybill, String startday, String endday, String total) {
        try {
            String sql = "update CarRentalInvoice set carid = ?,Accid = ?,"
                    + "songaythue= ?,donvi = ?,namecustomer = ?,CMND = ?,phone = ?,"
                    + "email = ?,code_gioithieu = ?,date_of_hire = ?,start_date_of_hire = ?, "
                    + "end_date_of_hire = ?,totalmoney = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carId);
            statement.setString(2, accId);
            statement.setString(3, thoiluong);
            statement.setString(4, donvi);
            statement.setString(5, nameCustomer);
            statement.setString(6, CMND);
            statement.setString(7, phone);
            statement.setString(8, email);
            statement.setString(9, code_inv);
            statement.setString(10, daybill);
            statement.setString(11, startday);
            statement.setString(12, endday);
            statement.setString(13, total);
            statement.setString(14, id);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editDichvu(String id, String nameCustomer, String email, String phone, String carName, String km, String bienso, String dichvu, String ngay, String gio) {
        try {
            String sql = "UPDATE BookingInvoice set namecustomer = ?,phone = ?,"
                    + "email = ?,date_maintenance = ?,carname = ?,km = ?,"
                    + "bienso = ?,dichvu = ?,gio = ? where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, nameCustomer);
            statement.setString(2, phone);
            statement.setString(3, email);
            
            statement.setString(4, ngay);
            statement.setString(5, carName);
            statement.setString(6, km);
            statement.setString(7, bienso);
            statement.setString(8, dichvu);
            statement.setString(9, gio);
            statement.setString(10, id);

            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void InsertCar(String name, String info, String img, String price, String current, String color, String catid) {
        try {
            String sql = "insert into Cars(name,info,img,price,[current],color,categoryid) values\n"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, info);
            statement.setString(3, img);
            statement.setString(4, price);
            statement.setString(5, current);
            statement.setString(6, color);
            statement.setString(7, catid);

            statement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void UpdateCar(String id, String name, String info, String img, String price, String current, String color) {
        try {
            String sql = "UPDATE Cars set name = ? ,info = ?,img = ?,price = ?,[current] = ?,color = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, info);
            statement.setString(3, img);
            statement.setString(4, price);
            statement.setString(5, current);
            statement.setString(6, color);

            statement.setString(7, id);

            statement.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Car> getCarPage(int pageindex, int gap) {
        ArrayList<Car> list = new ArrayList<>();
        try {
            String sql = "select c.*,rs.cateName from Cars c inner join\n"
                    + "(select ROW_NUMBER() over (order by car.id asc) as rownum,car.id,cat.name as cateName  from Cars car inner join Categories cat on cat.id = car.categoryid) as rs\n"
                    + "on c.id = rs.id where rs.rownum >= ((?-1) * ?) + 1 AND rownum <=  ?* ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (pageindex));
            statement.setInt(2, (gap));
            statement.setInt(3, (pageindex));
            statement.setInt(4, (gap));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Car s = new Car();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setInfo(rs.getString("info"));
                s.setImg(rs.getString("img"));
                s.setPrice(rs.getDouble("price"));
                s.setCurrent(!rs.getString("current").equals('0'));// chưa thuê 0 = false
                s.setColor(rs.getString("color"));
                s.setNameCat(rs.getString("cateName"));
                list.add(s);
            }
            return list;
        } catch (SQLException ex) {

        }
        return null;
    }

}
