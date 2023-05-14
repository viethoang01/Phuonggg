/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class BookingInvoice {
   private Map<String,ArrayList<BookingBill>> bookingBills;

    public BookingInvoice() {
        bookingBills =  new HashMap<>();
    }

    public void addBill(String accId,BookingBill bill) {
        ArrayList<BookingBill> listBill = new ArrayList<>();
        listBill.add(bill);
        if(bookingBills.get(accId) != null){
            bookingBills.replace(accId, listBill);
        }else{
            bookingBills.put(accId, listBill);
        }
    }

    public Map<String, ArrayList<BookingBill>> getBill() {
        return bookingBills;
    }

   
}
