/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Order;
import com.ijse.shoppingcart.repostory.custom.OrderRepository;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class OrderRepositoryImpl implements OrderRepository{
    private Connection connection=null;
    public OrderRepositoryImpl() throws Exception {
        connection=ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }

    @Override
    public boolean save(Order modal) throws Exception {
        return 0<connection.createStatement().executeUpdate("insert into orders values('"+modal.getOid()+"','"+modal.getDate()+"','"+modal.getTIME()+"','"+modal.getCid()+"','"+modal.getTOTALQTY()+"','"+modal.getTotalvalue()+"')");
    }

    @Override
    public boolean delete(Order modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Order modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
