/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.DTO;

import com.ijse.shoppingcart.modal.*;
import java.util.Objects;

/**
 *
 * @author Hafees
 */
public class ItemDTO extends SuperDTO{
    private String id;
    private String catid;
    private String description;
    private double price;
    private int  qty;
    private String  image;

   

    public ItemDTO() {
    }

    public ItemDTO(String id, String catid, String description, double price, int qty, String image) {
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
    public int hashCode() {
       
        int hash = 7;
      
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.description);
       
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
       
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemDTO other = (ItemDTO) obj;
        
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "id=" + id + ", catid=" + catid + ", description=" + description + ", price=" + price + ", qty=" + qty + ", image=" + image + '}';
    }
//    public static void main(String[] args) {
//        ItemDTO idto=new ItemDTO();
//        ItemDTO idto1=new ItemDTO();
//      
//        //Integer hashCode = idto.hashCode();
//       // System.out.println("idto "+idto);
//        //System.out.println("idto  hashcode "+idto.hashCode());
//        System.out.println("idto  hashcode id "+idto.equals(idto1));
//       
//    }
   
    
}
