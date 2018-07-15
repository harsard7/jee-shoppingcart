/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.util;


import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Hafees
 */
public class Jbcrypt {
 
    public  String hashPassword(String plainTextPassword){
       
         return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
}
    public  boolean checkPass(String plainPassword, String hashedPassword) {
        if (BCrypt.checkpw(plainPassword, hashedPassword)){
            System.out.println("The password matches.");
            return true;
        }else{
        System.out.println("The password does not match.");
          return false;
        }
    }
    public static void main(String[] args) throws Exception {
        String encter="$2a$10$cl7/NmNrFvi251IQwHI/1eaq2dTkz0siLaj/6IUbiqrmmYgEU.6Nq";
        java.sql.Connection connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
        Statement stm = connection.createStatement();
        
        stm.executeUpdate("insert into admin values('admin','"+encter+"')");
        ResultSet rst = stm.executeQuery("select * from admin where username='admin' and password='"+encter+"'");
        if(rst.next()){
            System.out.println(" rst"+rst.getString("username"));
            System.out.println(" rst"+rst.getString("password"));
            
        }
        System.out.println("");
        
        Jbcrypt en=new Jbcrypt();
     String hashPassword = en.hashPassword("123");
        System.out.println("hashPassword  "+hashPassword);
        en.checkPass("123", encter);
    }
    
}
