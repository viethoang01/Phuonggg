/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
           String sql = "select c.name,info,img,price,[current],color,cc.name as[cateName]\n" +
                        "from Cars c left join Categories cc \n" +
                        "on categoryid = cc.id ";
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet rs = statement.executeQuery();
           while(rs.next())
           {
               Car s = new Car();
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
    
}
