/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.connection.impl;

import com.ijse.shoppingcart.connection.ResourseConnection;
import java.sql.Connection;

/**
 *
 * @author Hafees
 */
public class SqlConnection implements ResourseConnection{

    @Override
    public Connection getConnection() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
