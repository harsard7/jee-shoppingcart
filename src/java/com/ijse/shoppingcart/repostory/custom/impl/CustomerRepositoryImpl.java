/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.repostory.SuperRepository;
import com.ijse.shoppingcart.repostory.custom.CustomerRepository;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class CustomerRepositoryImpl implements CustomerRepository{
    private Connection connection;

    public CustomerRepositoryImpl() throws Exception {
      
         connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }
    @Override
    public boolean save(Customer modal) throws Exception {
      
         Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("insert into customer values('"+modal.getId()+"','"+modal.getName()+"','"+modal.getPassword()+"','"+modal.getGender()+"','"+modal.getDob()+"','"+modal.getContact()+"')");
    }

    @Override
    public boolean delete(Customer modal) throws Exception {
         Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("delete from customer where id='"+modal.getId()+'"');
    }

    @Override
    public boolean update(Customer modal) throws Exception {
        Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("update  customer set name='"+modal.getName()+"',contact='"+modal.getContact()+"' where id='"+modal.getId()+'"');
    }

    @Override
    public Customer search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
