/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Item;
import com.ijse.shoppingcart.repostory.SuperRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafees
 */
public interface ItemRepository extends SuperRepository<Item>{
    
      public  List<Item> getAllItemwithlimit(int start ,int total) throws Exception ;
      public  int  getAllItemwcount() throws Exception ;
    
   
    }

