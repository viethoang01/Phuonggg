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
public class CarRentalInvoice {
    private Map<String,ArrayList<Bill>> bills;

    public CarRentalInvoice() {
        bills =  new HashMap<>();
    }

    public void addBill(String accId,Bill bill) {
        ArrayList<Bill> listBill = new ArrayList<>();
        listBill.add(bill);
        if(bills.get(accId) != null){
            bills.replace(accId, listBill);
        }else{
            bills.put(accId, listBill);
        }
    }

    public Map<String, ArrayList<Bill>> getBill() {
        return bills;
    }

    
   
   
    
}
