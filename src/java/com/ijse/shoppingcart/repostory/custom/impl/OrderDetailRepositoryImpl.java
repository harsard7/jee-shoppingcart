/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.OrderDetail;
import com.ijse.shoppingcart.repostory.custom.OrderDetailRepository;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class OrderDetailRepositoryImpl implements OrderDetailRepository{
     private Connection connection=null;
    public OrderDetailRepositoryImpl() throws Exception {
        connection=ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }
    
    @Override
    public boolean save(OrderDetail modal) throws Exception {
        return 0< connection.createStatement().executeUpdate("insert into orderdetail values('"+modal.getOid()+"','"+modal.getItemid()+"','"+modal.getDate()+"','"+modal.getQty()+"','"+modal.getPrice()+"')");
    }

    @Override
    public boolean delete(OrderDetail modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetail modal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
