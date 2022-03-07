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
        String s = "123456789";
        if(!s.matches("[a-zA-Z | 0-9]{1,9}")){
            System.out.println("chuan");
        }
    }
}
