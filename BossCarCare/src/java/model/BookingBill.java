/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class BookingBill {
    private String ngaybooking,id,accId,nameCustomer,email,phone,carName,km,bienso,dichvu,ngay,gio;

    public BookingBill() {
    }

    public BookingBill(String id,String accId, String nameCustomer, String email, String phone, String carName, String km, String bienso, String dichvu,String ngaybooking, String ngay, String gio) {
        this.accId = accId;
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.email = email;
        this.phone = phone;
        this.carName = carName;
        this.km = km;
        this.bienso = bienso;
        this.dichvu = dichvu;
        this.ngaybooking = ngaybooking;
        this.ngay = ngay;
        this.gio = gio;
    }

    public String getNgaybooking() {
        return ngaybooking;
    }

    public void setNgaybooking(String ngaybooking) {
        this.ngaybooking = ngaybooking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

   
    
}
