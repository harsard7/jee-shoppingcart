/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.connection.impl;

import com.ijse.shoppingcart.connection.ResourseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hafees
 */
public class MySqlConnection implements ResourseConnection{
    private Connection con=null;
    private Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    public MySqlConnection() {
        FileReader dbfilereader=null;
        try {
            Properties dbproperties=new Properties();
            File dbfile=new File("D:\\All files-IJSE\\IJSE\\Semester 3\\JavaEE\\Day-14-filters\\ShoppingCart\\settings\\dbconfiq.properties");
           
             //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //InputStream input = classLoader.getResourceAsStream("dbconfiq.properties");
            //InputStream input = classLoader.getResourceAsStream("com.ijse.shoppingcart.controllers.settings");
             
           // ClassLoader classLoader = getClass().getClassLoader();
//InputStream input = classLoader.getResourceAsStream("src/com/ijse/shoppingcart/controllers/settings/dbconfiq.properties");
               //System.out.println("input  "+input);
           // InputStream dbfile=new FileInputStream("settings/dbconfiq.properties");
             dbfilereader = new FileReader(dbfile);
             
            //InputStream resourceAsStream = MySqlConnection.class.getResourceAsStream("/settings/dbconfiq.properties");
           // System.out.println("resourceAsStream  "+resourceAsStream);
            dbproperties.load(dbfilereader);
            //System.out.println("dbfile  "+dbfile);
            String ip=dbproperties.getProperty("ip");
            String port=dbproperties.getProperty("port");
            String database=dbproperties.getProperty("database");
            String username=dbproperties.getProperty("username");
            String password=dbproperties.getProperty("password");
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+ip+":"+port+"/"+database;
            con = DriverManager.getConnection(url,username,password);
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbfilereader.close();
            } catch (IOException ex) {
                Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    @Override
   public Connection getConnection() throws ClassNotFoundException, SQLException {
       return con;
//        try {
////            Class.forName("com.mysql.jdbc.Driver");
////            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart","root","system");
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (SQLException ex) {
//            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        }
//        return con;
    }

    @Override
    public void closeConnection() throws Exception {
         try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception exp) {

        }
    }
    public static void main(String[] args) {
        new MySqlConnection();
    }
  }
    

