/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Item;
import com.ijse.shoppingcart.repostory.SuperRepository;
import com.ijse.shoppingcart.repostory.custom.ItemRepository;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class ItemRepositoryImpl implements ItemRepository{
     private Connection connection;

    public ItemRepositoryImpl() throws Exception {
         connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }
    @Override
    public boolean save(Item modal) throws Exception {
        Statement stm = connection.createStatement();
       
        return 0<stm.executeUpdate("insert into item values('"+modal.getId()+"','"+modal.getCatid()+"','"+modal.getDescription()+"','"+modal.getPrice()+"','"+modal.getQty()+"','"+modal.getImage()+"')");
    }

    @Override
    public boolean delete(Item modal) throws Exception {
        Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("delete from item  where id='"+modal.getId()+"'");
    }

    @Override
    public boolean update(Item modal) throws Exception {
       
        Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("update  item set catid='"+modal.getCatid()+"',description='"+modal.getDescription()+"',price='"+modal.getPrice()+"',qty='"+modal.getQty()+"',image='"+modal.getImage()+"' where id='"+modal.getId()+"'");
    }

    @Override
    public Item search(String id) throws Exception {
          Statement stm = connection.createStatement();
        
         ResultSet rst = stm.executeQuery("select * from item where id='"+id+"'");
     
          Item item=null;
         if(rst.next()){
             item=new Item( rst.getString("id"),rst.getString("catid"),rst.getString("description"),rst.getDouble("price"),rst.getInt("qty"),rst.getString("image"));
         
         }
       
         return item;
    }

    @Override
    public List<Item> getAll() throws Exception {
         Statement stm = connection.createStatement();
         ResultSet rst = stm.executeQuery("select * from item");
         List<Item>itemlist=null;
         while(rst.next()){
         Item item=new Item( 
                 rst.getString("id"),
                 rst.getString("catid"),
                 rst.getString("description"),
                 rst.getDouble("price"),
                 rst.getInt("qty"),
                 rst.getString("image")
                    );
         if(itemlist==null){
         itemlist=new ArrayList<>();
          }
         itemlist.add(item);
       }
         return itemlist;
         
        }

    @Override
    public List<Item> getAllItemwithlimit(int start, int total) throws Exception {
           System.out.println("getAllItemwithlimit "+start+"=="+total);
         Statement stm = connection.createStatement();
         ResultSet rst = stm.executeQuery("select * from item limit "+(start-1)+","+total);
         List<Item>itemlist=null;
         while(rst.next()){
         Item item=new Item( 
                 rst.getString("id"),
                 rst.getString("catid"),
                 rst.getString("description"),
                 rst.getDouble("price"),
                 rst.getInt("qty"),
                 rst.getString("image")
                    );
         if(itemlist==null){
         itemlist=new ArrayList<>();
          }
         itemlist.add(item);
         
       }
         return itemlist;
         
        }

    @Override
    public int getAllItemwcount() throws Exception {
        
        int count=0;
         Statement stm = connection.createStatement(); 
         ResultSet rs = stm.executeQuery("select count(*) from item");
        
         while(rs.next()){
	count=rs.getInt("COUNT(*)");						
         }
         return count;
    }
    
    
    }

    
    