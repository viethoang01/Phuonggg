/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import DAL.CarDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;
import model.BookingBill;
import model.Car;
import model.Message;

/**
 *
 * @author Administrator
 */
public class Test {

    public static void main(String[] args) {
        CarDAO dao = new CarDAO();
        ArrayList<Message> MYR = null;
        MYR = dao.getAllMessageofUser("44", "45");
        ArrayList<Message> MYS = null;
        MYS = dao.getAllMessageofUser("45", "44");
        int MYRidx = 0, MYSidx = 0, MYRid = 0, MYSid = 0, MYRidOLD = 0, MYSidOLD = 0;
        for (int i = 0; i < MYR.size() + MYS.size(); i++) {
            MYRid = Integer.parseInt(MYR.get(MYRidx).getId());
            MYSid = Integer.parseInt(MYS.get(MYSidx).getId());

         if (MYRid > MYSid) {
//                if (MYRidOLD == MYRid && MYSidOLD == MYSid) {
//                    System.out.println(MYR.get(MYRidx).getContent());
//                    System.out.println(MYRid + "R");
//                } else {
                    System.out.println(MYS.get(MYSidx).getContent());
                    System.out.println(MYSid + "s");
                    System.out.println(MYRid + ">" + MYSid);
                    MYRidOLD = MYRid;
                    MYSidOLD = MYSid;
                    if (MYSidx + 1 < MYS.size()) {
                        MYSidx++;
                    }
//                }
            } else {
//                if (MYRidOLD == MYRid && MYSidOLD == MYSid) {
//                    System.out.println(MYS.get(MYSidx).getContent());
//                    System.out.println(MYRid + "R");
//                } else {
                    System.out.println(MYR.get(MYRidx).getContent());
                    System.out.println(MYRid + "R");
                    System.out.println(MYRid + "<" + MYSid);
                    MYRidOLD = MYRid;
                    MYSidOLD = MYSid;
                    if (MYRidx + 1 < MYR.size()) {
                        MYRidx++;

                    }
//                }

            }

        }

    }
}
