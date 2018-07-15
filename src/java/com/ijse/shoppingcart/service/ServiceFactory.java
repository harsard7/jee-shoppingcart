/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.service.custom.impl.AdminServiceImpl;
import com.ijse.shoppingcart.service.custom.impl.CategoryServiceImpl;
import com.ijse.shoppingcart.service.custom.impl.CustomerServiceImpl;
import com.ijse.shoppingcart.service.custom.impl.ItemServiceImpl;
import com.ijse.shoppingcart.service.custom.impl.OrderDetailServiceImpl;
import com.ijse.shoppingcart.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author Hafees
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
        return new ServiceFactory();        
        }
        return serviceFactory;    
    }
    public SuperService getService(CONSTANTSTYPE constantstype) throws Exception{
        switch(constantstype){
            case ADMIN:return new AdminServiceImpl();
            case CUSTOMER:return new CustomerServiceImpl();
            case ITEM:return new ItemServiceImpl();
            case CATEGORY:return new CategoryServiceImpl();
            case ORDERS:return new OrderServiceImpl();
            case ORDERDETAIL:return new OrderDetailServiceImpl();
            default:return null;
        
        
        }
    
    }
    
    
}
