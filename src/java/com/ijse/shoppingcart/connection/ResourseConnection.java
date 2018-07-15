/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.connection;

import java.sql.Connection;

/**
 *
 * @author Hafees
 */
public interface ResourseConnection {
    
    public Connection getConnection()throws Exception;
    public void closeConnection()throws Exception;
}
