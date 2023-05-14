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
public class Bill {
    private String id,accId,carId,carname,thoiluong,donvi,nameCustomer,CMND,email,phone,code_inv,daybill,startday,endday,price,total;

    public Bill() {
    }

    public Bill(String id,String accId, String carId,String carname,String thoiluong, String donvi, String nameCustomer, String CMND, String email, String phone, String code_inv,String daybill, String startday, String endday, String price, String total) {
        this.accId = accId;
        this.id = id;
        this.carId = carId;
        this.thoiluong = thoiluong;
        this.donvi = donvi;
        this.nameCustomer = nameCustomer;
        this.CMND = CMND;
        this.email = email;
        this.phone = phone;
        this.code_inv = code_inv;
        this.startday = startday;
        this.endday = endday;
        this.price = price;
        this.total = total;
        this.carname = carname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDaybill() {
        return daybill;
    }

    public void setDaybill(String daybill) {
        this.daybill = daybill;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(String thoiluong) {
        this.thoiluong = thoiluong;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
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

    public String getCode_inv() {
        return code_inv;
    }

    public void setCode_inv(String code_inv) {
        this.code_inv = code_inv;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}
