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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Car;

/**
 *
 * @author Administrator
 */
public class CarDAO extends BaseDAO<Car>{

    @Override
    public ArrayList<Car> getAll() {
        ArrayList<Car> list = new ArrayList<>();
       try {
           String sql = "select c.id, c.name,info,img,price,[current],color,cc.name as[cateName]\n" +
                        "from Cars c left join Categories cc \n" +
                        "on categoryid = cc.id ";
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           while(rs.next())
           {
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
    public Car getCar(String id){
        try{
            String sql = "select c.id,c.name,info,img,price,[current],color,cc.name as[cateName]\n" +
                        "from Cars c left join Categories cc \n" +
                        "on categoryid = cc.id  where c.id = ?";
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
            
        }catch(SQLException ex){
            
        }
        return null;
    }
    
    
    public void SignupAcc(String name,String password){
        try{
            String sql = "insert into Account values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        }catch(SQLException ex){
            
        }
    }
    public ArrayList<Account> ListAcc(){
        ArrayList<Account> list = new ArrayList<>();
        try{
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
        }catch(SQLException ex){
            
        }
        return null;
    }
    public Account getAcc(String name){
        try{
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
            
        }catch(SQLException ex){
            
        }
        return null;
    }
    
    public void InsertRental(String Carid, String Accid,String songaythue, String donvi, String namecustomer, String CMND, String phone, String email, String code_gioithieu, String start_date_of_hire, String end_date_of_hire, String totalmoney){
        try{
            String sql = "insert into CarRentalInvoice values\n" +
"(?,?,?,?,?,?,?,?,?,?,?,?)";
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
        }catch(SQLException ex){
            
        }
    }
    
}
