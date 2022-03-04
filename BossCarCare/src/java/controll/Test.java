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
            char[] s = "Hoang Viet1".toCharArray();
            boolean check1 = false;
            for (int i = 0; i < s.length-1; i++) {
                if(Character.isLetter(s[i])&& s[i+1] == ' '){
                    check1 = true;
                }
                
            }
            LocalDate date = java.time.LocalDate.now();            
            Date startday1 =new SimpleDateFormat("dd/MM/yyyy").parse("12/2/2022");
            System.out.println(startday1);
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
