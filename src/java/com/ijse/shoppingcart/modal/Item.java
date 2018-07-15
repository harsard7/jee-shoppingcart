/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.modal;

/**
 *
 * @author Hafees
 */
public class Item extends SuperModal{
    private String id;
    private String catid;
    private String description;
    private double price;
    private int  qty;
    private String  image;

   

    public Item() {
    }

    public Item(String id, String catid, String description, double price, int qty, String image) {
        this.id = id;
        this.catid = catid;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", catid=" + catid + ", description=" + description + ", price=" + price + ", qty=" + qty + ", image=" + image + '}';
    }

   
    
    
}
