/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.connection.ConnectionFactory;
import com.ijse.shoppingcart.modal.Category;
import com.ijse.shoppingcart.repostory.SuperRepository;
import com.ijse.shoppingcart.repostory.custom.CategoryRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class CategoryRepositoryImpl implements CategoryRepository{
    private Connection connection;

    public CategoryRepositoryImpl() throws Exception {
         connection = ConnectionFactory.getInstanse().getConnectionType(CONSTANTSTYPE.MYSQL).getConnection();
    }
    @Override
    public boolean save(Category modal) throws Exception {
        Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("insert into category values('"+modal.getId()+"','"+modal.getName()+"')");
    }

    @Override
    public boolean delete(Category modal) throws Exception {
         Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("delete from category category where id='"+modal.getId()+"'");
    }

    @Override
    public boolean update(Category modal) throws Exception {
         Statement stm = connection.createStatement();
        return 0<stm.executeUpdate("update category set name='"+modal.getName()+"' where id='"+modal.getId()+"'");
    }

    @Override
    public Category search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> getAll() throws Exception {
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("select * from category ORDER BY name");
        List<Category>allcategory=null;
        while(rst.next()){
        Category c=new Category(rst.getString("id"),rst.getString("name"));
            if(allcategory==null){
                allcategory=new ArrayList<>();
            }
            allcategory.add(c);
        }
        return allcategory;
        
    }
}
