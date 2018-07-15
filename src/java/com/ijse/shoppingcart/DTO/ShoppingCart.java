/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.DTO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Hafees
 */
public class ShoppingCart {
  
     private HashMap<ItemDTO,Integer>itemcart=null;
     private double totalprice=0.0;
     private int totalqty=0;

    public HashMap<ItemDTO, Integer> getItemcart() {
        return itemcart;
    }

    public void setItemcart(HashMap<ItemDTO, Integer> itemcart) {
        this.itemcart = itemcart;
    }

    public double getTotalprice() {
        return totalprice;
    }
    public int getTotalQty(){
    return totalqty;
    }
   

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    public void setTotalqty(int totalqty) {
        this.totalqty = totalqty;
    }

    public ShoppingCart() {
        itemcart=new HashMap<>();
    }
    public boolean updateqtycart(ItemDTO itemDTO,Integer qty){
          itemcart.put(itemDTO, qty);
          calculateTotal();
          calculateTotalqty();
    return true;
    }
    
    
    public boolean addtocart(ItemDTO itemDTO){
        if(itemcart.containsKey(itemDTO)){
            itemcart.put(itemDTO,1+itemcart.get(itemDTO));
        }else{
        itemcart.put(itemDTO,1);
        }
        calculateTotal();
        return true;
    }
    public void calculateTotal(){
        double sum=0;
         Set<ItemDTO> itemkey = itemcart.keySet();
         Iterator<ItemDTO> iterator = itemkey.iterator();
        
         while(iterator.hasNext()){
            ItemDTO item = iterator.next();
             sum+= itemcart.get(item)*item.getPrice();
             
             System.out.println("sum "+sum);
         }
        this.setTotalprice(sum);
    }
    public boolean deleteFromCart(ItemDTO itemDTO){
            itemcart.remove(itemDTO);
            calculateTotal();
            return true;
    
    }
    
    public void calculateTotalqty(){
        int sum=0;
         Set<ItemDTO> itemskey = itemcart.keySet();
         Iterator<ItemDTO> items = itemskey.iterator();
         while(items.hasNext()){
            ItemDTO item = items.next();
             sum+= itemcart.get(item);
         }
         System.out.println("sum qty == "+sum);
        this.setTotalqty(sum);
    }
    
}
