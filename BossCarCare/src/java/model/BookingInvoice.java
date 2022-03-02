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
public class BookingInvoice {
    private int id,Accid;
    private String donvi,namecustomer,CMND,phone,email,code_gioithieu;
    private Date date_of_booking, date_maintenance;

    public BookingInvoice() {
    }
    public BookingInvoice(int Accid, String donvi, String namecustomer, String CMND, String phone, String email, String code_gioithieu){
        this.Accid = Accid;
        this.donvi = donvi;
        this.namecustomer = namecustomer;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
        this.code_gioithieu = code_gioithieu;  
    }
    public BookingInvoice(int id, int Accid, String donvi, String namecustomer, String CMND, String phone, String email, String code_gioithieu, Date date_of_booking, Date date_maintenance) {
        this.id = id;
        this.Accid = Accid;
        this.donvi = donvi;
        this.namecustomer = namecustomer;
        this.CMND = CMND;
        this.phone = phone;
        this.email = email;
        this.code_gioithieu = code_gioithieu;
        this.date_of_booking = date_of_booking;
        this.date_maintenance = date_maintenance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccid() {
        return Accid;
    }

    public void setAccid(int Accid) {
        this.Accid = Accid;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getNamecustomer() {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode_gioithieu() {
        return code_gioithieu;
    }

    public void setCode_gioithieu(String code_gioithieu) {
        this.code_gioithieu = code_gioithieu;
    }

    public Date getDate_of_booking() {
        return date_of_booking;
    }

    public void setDate_of_booking(Date date_of_booking) {
        this.date_of_booking = date_of_booking;
    }

    public Date getDate_maintenance() {
        return date_maintenance;
    }

    public void setDate_maintenance(Date date_maintenance) {
        this.date_maintenance = date_maintenance;
    }
    
}
