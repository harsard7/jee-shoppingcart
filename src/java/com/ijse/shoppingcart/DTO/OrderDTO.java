/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.DTO;

/**
 *
 * @author Hafees
 */
public class OrderDTO extends SuperDTO{
    private String oid;
    private String date;
    private String TIME;    
    private String cid;
    private int TOTALQTY;
    private double totalvalue;

    public OrderDTO(String oid, String date, String TIME, String cid, int TOTALQTY, double totalvalue) {
        this.oid = oid;
        this.date = date;
        this.TIME = TIME;
        this.cid = cid;
        this.TOTALQTY = TOTALQTY;
        this.totalvalue = totalvalue;
    }

    
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getTOTALQTY() {
        return TOTALQTY;
    }

    public void setTOTALQTY(int TOTALQTY) {
        this.TOTALQTY = TOTALQTY;
    }

    public double getTotalvalue() {
        return totalvalue;
    }

    public void setTotalvalue(double totalvalue) {
        this.totalvalue = totalvalue;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "oid=" + oid + ", date=" + date + ", TIME=" + TIME + ", cid=" + cid + ", TOTALQTY=" + TOTALQTY + ", totalvalue=" + totalvalue + '}';
    }

    
   
    
}
