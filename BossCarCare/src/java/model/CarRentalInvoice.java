/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class CarRentalInvoice extends BookingInvoice{
    private int id,Carid;
    private Date date_of_hire,start_date_of_hire,end_date_of_hire;
    private int totalmoney;

    public CarRentalInvoice() {
    }

    public CarRentalInvoice(int id,int Carid, int Accid, String donvi, String namecustomer, String CMND, String phone, String email, String code_gioithieu, Date date_of_hire, Date start_date_of_hire, Date end_date_of_hire, int totalmoney) {
        super(Accid, donvi, namecustomer, CMND, phone, email, code_gioithieu);
        this.id = id;
        this.Carid = Carid;
        this.date_of_hire = date_of_hire;
        this.start_date_of_hire = start_date_of_hire;
        this.end_date_of_hire = end_date_of_hire;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getCarid() {
        return Carid;
    }

    public void setCarid(int Carid) {
        this.Carid = Carid;
    }

    public Date getDate_of_hire() {
        return date_of_hire;
    }

    public void setDate_of_hire(Date date_of_hire) {
        this.date_of_hire = date_of_hire;
    }

    public Date getStart_date_of_hire() {
        return start_date_of_hire;
    }

    public void setStart_date_of_hire(Date start_date_of_hire) {
        this.start_date_of_hire = start_date_of_hire;
    }

    public Date getEnd_date_of_hire() {
        return end_date_of_hire;
    }

    public void setEnd_date_of_hire(Date end_date_of_hire) {
        this.end_date_of_hire = end_date_of_hire;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }
    
    
}
