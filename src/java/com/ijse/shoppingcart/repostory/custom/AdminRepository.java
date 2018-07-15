/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.controllers.AdminServletController;
import com.ijse.shoppingcart.modal.Admin;
import com.ijse.shoppingcart.repostory.SuperRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hafees
 */
public interface AdminRepository extends SuperRepository<Admin>{
    
    static Admin verifyAdmin(String name,String password) throws ClassNotFoundException, SQLException, Exception{
       Admin a=null;
       
                Connection connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("select * from admin where username='"+name+"'and password='"+password+"'");
              
                 
                while(rst.next()){
                     a=new Admin(rst.getString("username"), rst.getString("password"));
                }
       return a;
    }
   
    public static Admin searchAdmin(String id) throws Exception {
         Connection connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * from admin where username='"+id+"'");
         Admin admin=null;
            while(rst.next()){
                 admin=new Admin(rst.getString("username"), rst.getString("password"));
                
            }
            return admin;
    }
}
