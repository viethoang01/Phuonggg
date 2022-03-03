/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        char[] s = "Hoang Viet1".toCharArray();
        boolean check1 = false;
        for (int i = 0; i < s.length-1; i++) {
            if(Character.isLetter(s[i])&& s[i+1] == ' '){
                check1 = true;
            }
            
        }
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(300000000);
    }
}
