/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {
        try {
            //        try {
//
//            LocalDate date = java.time.LocalDate.now();
//            Date startday1 = new SimpleDateFormat("dd/MM/yyyy").parse("12/2/2022");
//
//        } catch (ParseException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        LocalDate date = java.time.LocalDate.now();
//        String startday = java.time.LocalDate.parse("05--02").format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//        System.out.println(startday);
            
            Date startday1 = new SimpleDateFormat("MM/dd/yyyy").parse("03/05/2022");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            String strDate = formatter.format(startday1);
            System.out.println("Date Format with MM/dd/yyyy : " + strDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
