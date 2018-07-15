/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.repostory.custom.impl.AdminRepositoryImpl;
import com.ijse.shoppingcart.repostory.custom.impl.CategoryRepositoryImpl;
import com.ijse.shoppingcart.repostory.custom.impl.CustomerRepositoryImpl;
import com.ijse.shoppingcart.repostory.custom.impl.ItemRepositoryImpl;
import com.ijse.shoppingcart.repostory.custom.impl.OrderDetailRepositoryImpl;
import com.ijse.shoppingcart.repostory.custom.impl.OrderRepositoryImpl;

/**
 *
 * @author Hafees
 */
public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }
    public static RepositoryFactory getInstance(){
        if(repositoryFactory==null){
        return new RepositoryFactory();        
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(CONSTANTSTYPE constantstype) throws Exception{
        switch(constantstype){
            case ADMIN:return new AdminRepositoryImpl();
            case CUSTOMER:return new CustomerRepositoryImpl();
            case ITEM:return new ItemRepositoryImpl();
            case CATEGORY:return new CategoryRepositoryImpl();
            case ORDERS:return new OrderRepositoryImpl();
            case ORDERDETAIL:return new OrderDetailRepositoryImpl();
            default:return null;
        }
    
    }
    
}
