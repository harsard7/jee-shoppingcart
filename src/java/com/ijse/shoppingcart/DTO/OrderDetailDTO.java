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
public class OrderDetailDTO extends SuperDTO{
    private String oid;
    private String itemid;
    private String date;
    private int qty;
    private double price;

    public OrderDetailDTO(String oid, String itemid, String date, int qty, double price) {
        this.oid = oid;
        this.itemid = itemid;
        this.date = date;
        this.qty = qty;
        this.price = price;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "oid=" + oid + ", itemid=" + itemid + ", date=" + date + ", qty=" + qty + ", price=" + price + '}';
    }
   
 

   
}
