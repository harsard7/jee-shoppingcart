/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.repostory.SuperRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hafees
 */
public interface CustomerRepository extends SuperRepository<Customer>{
     
    public static Customer getCustomerbyname(String name) throws SQLException, Exception{
      Connection  con=ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
         Statement stm = con.createStatement();
         ResultSet rst = stm.executeQuery("select * from customer where name='"+name+"'");
           Customer c=null;
         while(rst.next()){
          c=new Customer(rst.getString("id"), rst.getString("name"), rst.getString("password"), rst.getString("gender"), rst.getString("dob"),rst.getInt("contact"));
         
         }
        
        return c;
    
    
    }
    
}
