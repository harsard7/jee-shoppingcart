/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.connection;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.impl.MySqlConnection;
import com.ijse.shoppingcart.connection.impl.SqlConnection;

/**
 *
 * @author Hafees
 */
public class ConnectionFactory {
    private static ConnectionFactory connectionFactory;

    private ConnectionFactory() {
        
    }
    
    public static ConnectionFactory getInstanse(){
        if(connectionFactory==null){
        return new ConnectionFactory();
        }
        return connectionFactory;
    }
    public ResourseConnection getConnectionType(CONSTANTSTYPE connectiontype){
                switch(connectiontype){
                    case SQL:return new SqlConnection();
                    case MYSQL:return new MySqlConnection();
                    default :return null;
                
                }
        
    }
    
    
    
    
}
