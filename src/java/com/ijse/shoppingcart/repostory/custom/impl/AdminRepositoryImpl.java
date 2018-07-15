/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Admin;
import com.ijse.shoppingcart.repostory.SuperRepository;
import com.ijse.shoppingcart.repostory.custom.AdminRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class AdminRepositoryImpl implements AdminRepository{
    private Connection connection;

    public AdminRepositoryImpl() throws Exception {
         connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }
    
    @Override
    public boolean save(Admin modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Admin modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Admin modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin search(String id) throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * from admin where username='"+id+"'");
         Admin admin=null;
            while(rst.next()){
                 admin=new Admin(rst.getString("username"), rst.getString("password"));
                
            }
            return admin;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
